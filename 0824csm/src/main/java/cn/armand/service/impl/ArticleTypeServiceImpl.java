package cn.armand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.armand.domain.ArticleType;
import cn.armand.mapper.ArticleTypeMapper;
import cn.armand.service.IArticleTypeService;


@Service
public class ArticleTypeServiceImpl implements IArticleTypeService {
	
	@Autowired
	private ArticleTypeMapper typemapper;

	@Override
	public List<ArticleType> findAll() {
		return typemapper.findAll();
	}

}
