package cn.armand.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.armand.domain.Slide;
import cn.armand.mapper.SlideMapper;
import cn.armand.query.SlideQuery;
import cn.armand.service.ISlideService;
import cn.armand.util.PageBean;

@Service
public class SlideServiceImpl implements ISlideService {
	@Autowired
	private SlideMapper mapper;
	@Override
	public PageBean<Slide> findPage(SlideQuery query) {
		//1. 先查询总数 若总数量为0 不为0 继续查询分页数据
		Integer totals = mapper.findCount(query);
		if(totals==0) {
			return new PageBean<Slide>();
		}
		//2. 查询分页数据
		List<Slide> data = mapper.findPage(query);
		//3. 将上面的两个值组装PageBean
		return new PageBean<Slide>(totals, data);
	}
	@Override
	public void save(Slide slide, HttpServletRequest req, MultipartFile photo) {
		InputStream is = null;
		FileOutputStream fos = null;
		// 用户上传了图片
		if(photo!=null&&photo.getSize()>0) {
			try {
				//1. 文件上传 获取输入流
				is = photo.getInputStream();
				//2. 输出流
				String uploadPath = req.getServletContext().getRealPath("/upload");
				File file = new File(uploadPath);
				if(!file.exists()) {
					file.mkdir();
				}
				String originalFilename = photo.getOriginalFilename();
				String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
				String fileName = System.currentTimeMillis()+suffix;
				fos =  new FileOutputStream(new File(file,fileName));
				//3. 工具类上传
				IOUtils.copy(is, fos);
				
				//4. 将name和path设置回slide对象中
				slide.setName(fileName);
				slide.setPath("/upload/"+fileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(is!=null)
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if(fos!=null)
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		//5.添加到数据库
		if(slide.getId()==null) {//添加
			if(photo!=null&&photo.getSize()>0) {
				mapper.add(slide);
			}	
		}else {
			
			//1.上传了图片======Slide[id=3, name=null, path=null]
			//2.没有上传图片======Slide[id=3, name=1599485493943.xml, path=/upload/1599485493943.xml]
			Slide dbSlide = mapper.findOne(slide.getId()); //获取未修改前的图片对象
			mapper.update(slide);
			//如果上传了图片就删除原始的图片信息
			if(photo!=null&&photo.getSize()>0) {
				String uploadPath = req.getServletContext().getRealPath("/upload");
				File file = new File(uploadPath, dbSlide.getName());
				if(file.exists()) {
					file.delete();
				}
			}
			
		}
		
		
		
	}
	@Override
	public void del(Long id, HttpServletRequest req) {
		//1. 先删数据，再删图片
		Slide slide=mapper.findOne(id);
		mapper.del(id);  
		String uploadPath = req.getServletContext().getRealPath("/upload");
		File file = new File(uploadPath, slide.getName());
		if(file.exists()) {
			file.delete();//如果轮播图存在就删除
		}
	}
	@Override
	public List<Slide> getSlides() {
		return mapper.findSlides();
	}
		

}
