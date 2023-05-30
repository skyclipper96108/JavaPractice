package cn.jacob.mybatisdao.test;


import org.junit.Test;

import cn.jacob.mybatisdao.dao.EmpDaoImpl;
import cn.jacob.mybatisdao.dao.IEmpDao;
import cn.jacob.mybatisdao.domain.Emp;

public class TestCase {
	IEmpDao dao = new EmpDaoImpl();
	@Test
	public void testFindOne() throws Exception {
		System.out.println(dao.findOne(1));
	}
	
	@Test
	public void testFindAll() throws Exception {
		System.out.println(dao.findAll());
	}
	
//	@Test
//	public void testAdd() throws Exception {
//		dao.addEmp(new Emp("justin","0383657"));
//	}
	@Test
	public void updateAdd() throws Exception {
		Emp emp = dao.findOne(6);
		emp.setUsername("god");
		emp.setPassword("99812");
		dao.update(emp);
	}
	
	
	
}
