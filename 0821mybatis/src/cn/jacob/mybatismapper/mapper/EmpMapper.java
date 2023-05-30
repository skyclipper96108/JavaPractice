package cn.jacob.mybatismapper.mapper;

import java.util.List;

import cn.jacob.mybatismapper.domain.Emp;



public interface EmpMapper {
	// ²éÑ¯
	List<Emp> findAll();
	Emp findOne(Integer id);
	// ÔöÉ¾¸Ä
	void addEmp(Emp emp);
	void delEmp(Integer id);
	void update(Emp emp);
}
