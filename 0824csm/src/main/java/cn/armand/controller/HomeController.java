package cn.armand.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.armand.domain.Article;
import cn.armand.domain.Slide;
import cn.armand.service.IArticleService;
import cn.armand.service.ISlideService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private IArticleService service;
	
	@Autowired
	private ISlideService slideService;
	
	
	@RequestMapping("/articles")
	@ResponseBody
	public Map<String, Object>getArticles(){
		return service.getArticles();
	}
	@RequestMapping("/updateClickCount")
	@ResponseBody
	public Article updateClickCount(String url) {
		return service.updateClickCount(url);
	}
	/**
	 * 查询所有轮播图
	 * @return
	 */
	@RequestMapping("/slides")
	@ResponseBody
	public List<Slide> getSlide(String url) {
		return slideService.getSlides();
	}
	
	
}
