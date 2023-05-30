package cn.armand.test;


import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.armand.mapper.EmpMapper;
import cn.armand.service.IEmpService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
	
	@Resource
	private Date now;
	
	@Resource
	private BasicDataSource source;
	
	@Resource
	private SqlSessionFactory factory;
	
	@Resource
	private IEmpService service;
	
	@Autowired
	private EmpMapper mapper;
	@Test
	public void testName() throws Exception {
		System.out.println(now);
		System.out.println(source);
		System.out.println(factory);
		System.out.println(source.getConnection());
//		System.out.println(service.findAll());
		System.out.print(mapper.findOne(1));
	}
}
