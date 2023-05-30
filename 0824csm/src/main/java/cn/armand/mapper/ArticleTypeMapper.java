package cn.armand.mapper;


import java.util.List;

import cn.armand.domain.ArticleType;

public interface ArticleTypeMapper {
	/**
	 * 根据文章类型查询文章类型对象
	 * @return
	 */
	ArticleType findOne(Long typeId);
	
	/**
	 * 查询所有文章类型
	 */
	List<ArticleType> findAll();
}
