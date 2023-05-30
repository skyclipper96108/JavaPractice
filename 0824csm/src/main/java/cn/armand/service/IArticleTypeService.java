package cn.armand.service;

import java.util.List;
import cn.armand.domain.ArticleType;

public interface IArticleTypeService {
	/**
	 * 查询所有
	 * @return
	 */
	
	List<ArticleType> findAll();
}
