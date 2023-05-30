package cn.armand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.armand.domain.Article;
import cn.armand.domain.ArticleType;
import cn.armand.query.ArticleQuery;
import cn.armand.service.IArticleService;
import cn.armand.service.IArticleTypeService;
import cn.armand.util.PageBean;

@Controller
@RequestMapping("/system/article")
public class ArticleController {
	@Autowired
	private IArticleService service;
	
	@Autowired
	private IArticleTypeService typeservice;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public PageBean<Article> findAll(){
		// grandmap对返回的数据有格式要求
		PageBean<Article> pageBean = service.findAll();
        return pageBean;
    }
	@RequestMapping("/index")
	public String index(Model model){		
		// 跳转到文章首页时，查询所有的文章类型，在文章首页中动态的显示文章类型的名称
		List<ArticleType> types = typeservice.findAll();
		model.addAttribute("types",types);
		return "article/article";
	}
	
	@RequestMapping("/findPage")
	@ResponseBody
	public PageBean<Article> findPage(ArticleQuery query){
		// grandmap对返回的数据有格式要求
		PageBean<Article> pageBean = service.findPage(query);
        return pageBean;
    }
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
	/**
	 * 添加和更新
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(Article article, HttpServletRequest req){
        try {
        	service.save(article, req);
        	return "ok";
        }catch(Exception e){
        	e.printStackTrace();
        	return "no";
        }
    }

}
