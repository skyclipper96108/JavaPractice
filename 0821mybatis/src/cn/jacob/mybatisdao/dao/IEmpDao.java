package cn.jacob.mybatisdao.dao;

import java.util.List;

import cn.jacob.mybatisdao.domain.Emp;

public interface IEmpDao {
	// ²éÑ¯
	List<Emp> findAll();
	Emp findOne(Integer id);
	// ÔöÉ¾¸Ä
	void addEmp(Emp emp);
	void delEmp(Integer id);
	void update(Emp emp);
}
