package cn.armand.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import cn.armand.domain.Slide;
import cn.armand.query.SlideQuery;
import cn.armand.util.PageBean;

public interface ISlideService {
	/**
	 * 分页+高级
	 * @param query
	 * @return
	 */
	PageBean<Slide> findPage(SlideQuery query);
	/**
	 * 上传图片
	 * @param slide
	 * @param req
	 * @param photo
	 */
	void save(Slide slide, HttpServletRequest req, MultipartFile photo);
	
	/**
	 * 删除轮播图
	 * @param id
	 * @param req
	 */
	void del(Long id, HttpServletRequest req);
	/**
	 * 显示所有启用的轮播图
	 * @return
	 */
	List<Slide> getSlides();
	
}
