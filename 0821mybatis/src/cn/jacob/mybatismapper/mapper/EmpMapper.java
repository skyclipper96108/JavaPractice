package cn.jacob.mybatismapper.mapper;

import java.util.List;

import cn.jacob.mybatismapper.domain.Emp;



public interface EmpMapper {
	// ��ѯ
	List<Emp> findAll();
	Emp findOne(Integer id);
	// ��ɾ��
	void addEmp(Emp emp);
	void delEmp(Integer id);
	void update(Emp emp);
}
