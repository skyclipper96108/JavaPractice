package cn.jacob.mybatismapper.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import cn.jacob.mybatismapper.mapper.EmpMapper;
import cn.jacob.utils.MybatisUtil;

public class TestCase {

	@Test
	public void testFindOne() throws Exception {
		SqlSession session = MybatisUtil.getSession();
		EmpMapper mapper  = session.getMapper(EmpMapper.class);
		System.out.println(mapper.findOne(2));
	}
	
	
	
}
