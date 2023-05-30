package cn.armand.mapper;
import java.util.List;

import cn.armand.domain.Emp;
import cn.armand.domain.Empp;
import cn.armand.query.EmpQuery;

public interface EmpMapper {
	List<Emp> findAll();

	List<Emp> findByCondition(EmpQuery query);
	
	Empp findOne(Integer id);
	List<Empp> findAllp();
	
	void addEmpp(Empp empp);
	
	void delEmpp(Integer id);
	
	void updateEmpp(Empp empp);
}
