package cn.kevincrud.service.impl;

import java.util.List;

import cn.kevincrud.dao.impl.EmpDaoImpl;
import cn.kevincrud.domain.Emp;
import cn.kevincrud.dao.IEmpDao;
import cn.kevincrud.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	IEmpDao dao = new EmpDaoImpl();

	@Override
	public List<Emp> findAll() {
		return dao.findAll();
	}
	
}
