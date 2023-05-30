package cn.armand.mapper;

import java.util.List;

import cn.armand.domain.Article;
import cn.armand.query.ArticleQuery;

public interface ArticleMapper {
	/**
	 * 查询所有
	 * @return
	 */
	List<Article> findAll();

	//分页的总数量
	Integer findCount(ArticleQuery query);
	//分页的数据
	List<Article> findPage(ArticleQuery query);

	void del(Long id);

	void add(Article article);

	void update(Article article);
	/**
	 * 前台显示所有启用的文章
	 * @param technology
	 * @return
	 */
	List<Article> findArticles(String technology);
	/**
	 * 删除静态资源时根据id查询url
	 * @param id
	 * @return
	 */
	Article findOne(Long id);
	/**
	 * 更新点击次数
	 * @param url
	 * @return
	 */
	Article findOneByUrl(String url);
}
