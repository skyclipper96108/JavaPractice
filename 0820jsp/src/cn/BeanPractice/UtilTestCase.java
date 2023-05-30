package cn.BeanPractice;


import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class UtilTestCase {
	@Test
	public void testCopy() throws Exception {
		Emp emp1= new Emp(1, "tom", "2133532");
		Emp emp2 = new Emp();
		System.out.println("����֮ǰ"+emp1);
		BeanUtils.copyProperties(emp2, emp1);
		System.out.println("����֮��"+emp2);	
	}
	// ��map�е����ݸ��Ƹ�����
	@Test
	public void testmap() throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("username", "jiba");
		map.put("password", "123554");
		Emp emp = new Emp();
		System.out.println("����֮ǰ"+emp);
		BeanUtils.copyProperties(emp, map);
		System.out.println("����֮��"+emp);	
	}
}
