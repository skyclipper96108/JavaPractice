package cn.armand.mapper;

import java.util.List;

import cn.armand.domain.Slide;
import cn.armand.query.SlideQuery;

public interface SlideMapper {

	Integer findCount(SlideQuery query);

	List<Slide> findPage(SlideQuery query);

	void add(Slide slide);

	Slide findOne(Long id);

	void del(Long id);

	void update(Slide slide);

	List<Slide> findSlides();

}
