package cn.armand.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.armand.domain.Slide;
import cn.armand.query.SlideQuery;
import cn.armand.service.ISlideService;
import cn.armand.util.PageBean;

@Controller
@RequestMapping("/system/slide")
public class SlideController {
	
	@Autowired
	private ISlideService service;
	/**
	 * 跳转到轮播图的首页
	 * @return
	 */
	@RequestMapping("/index")
	public String goIndex() {
		return "slide/slide";
	}
	/**
	 * slide的分页查询+高级查询
	 * @return
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public PageBean<Slide> findPage(SlideQuery query) {
		return service.findPage(query);
	}
	/**
	 * 文件图片上传
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Slide slide, HttpServletRequest req, MultipartFile photo) {
		try {
			service.save(slide,req,photo);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
	}
	/**
	 * 删除轮播图
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public String del(Long id, HttpServletRequest req){
        try {
        	service.del(id, req);
        	return "ok";
        }catch(Exception e){
        	e.printStackTrace();
        	return "no";
        }
    }
	
	
}
