package cn.armand.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.armand.domain.Article;
import cn.armand.query.ArticleQuery;
import cn.armand.util.PageBean;

public interface IArticleService {
	/**
	 * 查询所有
	 * @return
	 */
	PageBean<Article> findAll();

	PageBean<Article> findPage(ArticleQuery query);

	void del(Long id, HttpServletRequest req);

	void save(Article article, HttpServletRequest req);
	
	/**
	 * 前台查询所有文章
	 * @return
	 */
	Map<String, Object> getArticles();
	
	/**
	 * 更新点击次数
	 * @param url
	 * @return
	 */
	Article updateClickCount(String url);
	
	
	
}
