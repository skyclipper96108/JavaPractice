package cn.armand.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.armand.domain.Article;
import cn.armand.domain.ArticleType;
import cn.armand.mapper.ArticleMapper;
import cn.armand.mapper.ArticleTypeMapper;
import cn.armand.query.ArticleQuery;
import cn.armand.service.IArticleService;
import cn.armand.util.Constant;
import cn.armand.util.FreeMarkerUtil;
import cn.armand.util.PageBean;

@Service
public class ArticleServiceImpl implements IArticleService {
	
	@Autowired
	private ArticleMapper mapper;
	@Autowired
	private ArticleTypeMapper typemapper;
	
	@Override
	public PageBean<Article> findAll() {
		List<Article> articles = mapper.findAll();
		for(Article article:articles) {
			// 获取文章对应的id
			Long typeId = article.getTypeId();
			// 根据文章类型id查询文章类型
			ArticleType type = typemapper.findOne(typeId);
			article.setType(type);
		}
		return new PageBean<>(articles.size(),articles);
	}

	@Override
	public PageBean<Article> findPage(ArticleQuery query) {
		Integer count = mapper.findCount(query);
		if(count==0) return new PageBean<>();
		// 根据分页的信息查询分页的数据
		List<Article> articles = mapper.findPage(query);
		for(Article article:articles) {
			// 获取文章对应的id
			Long typeId = article.getTypeId();
			// 根据文章类型id查询文章类型
			ArticleType type = typemapper.findOne(typeId);
			article.setType(type);
		}
		return new PageBean<>(count,articles);
	}

	@Override
	public void del(Long id, HttpServletRequest req) {
		// 使用上下文对象获取template的路径
		String templatePath = req.getServletContext().getRealPath("/static/template");
		Article article = mapper.findOne(id);// 为了获取url
		mapper.del(id);
		// 删除静态页面
		if(article.getUrl()!=null) {
			File file = new File(templatePath, article.getUrl());
			if(file.exists())file.delete();
		}
		
	}

	@Override
	public void save(Article article,HttpServletRequest req) {
		// 使用上下文对象获取template的路径
		String templatePath = req.getServletContext().getRealPath("/static/template");
		// 调用工具类生成相应的静态资源，并返回静态页面的名称
		String url = FreeMarkerUtil.getStaticFile(templatePath, "article.ftl", article, ".html");
		// 将静态页面的名称设置回对象，保存到数据库
		article.setUrl(url);
		if(article.getId()==null) {
			mapper.add(article);
		}else {
			// 根据id查询数据库对象
			Article dbArticle = mapper.findOne(article.getId());
			mapper.update(article);
			// 删除静态页面
			if(dbArticle.getUrl()!=null) {
				File file = new File(templatePath, dbArticle.getUrl());
				if(file.exists())file.delete();
			}
		}
		
	}
	
	@Override
	public Map<String, Object> getArticles() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 1.根据code查询所有的文章，返回list，将集合添加到Map中返回
		List<Article> technologys = mapper.findArticles(Constant.TECHNOLOGY);
		map.put("technologys", technologys);
		// 查询所有的行业新闻
		List<Article> industrys = mapper.findArticles(Constant.INDUSTRY);
		map.put("industrys",industrys);
		// 查询所有的学科资讯
		List<Article> subjects = mapper.findArticles(Constant.SUBJECT); 
		map.put("subjects",subjects);
		return map;
	}

	@Override
	public Article updateClickCount(String url) {
		// 1. 根据url查询数据库的原始对象
		Article oldArticle = mapper.findOneByUrl(url);
		// 2. 获取原始对象的clickCount
		Integer oldclickCount = oldArticle.getClickCount();
		// 3. 将原始对象的clickCount+1设置回对象
		oldArticle.setClickCount(oldclickCount+1);
		// 4. 更新数据库为最新的点击次数的对象
		mapper.update(oldArticle);
		// 5. 将更新对象返回
		return oldArticle;
	}

}
