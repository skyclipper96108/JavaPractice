package cn.armand.service;

import cn.armand.domain.Emp;
import cn.armand.domain.Empp;
import cn.armand.query.EmpQuery;

import java.util.List;


public interface IEmpService {
	
	public List<Emp> findAll();

	public List<Emp> findByCondition(EmpQuery query);

	public List<Empp> findAllp();

	public void del(Integer eid);

	public void save(Empp empp);

}
