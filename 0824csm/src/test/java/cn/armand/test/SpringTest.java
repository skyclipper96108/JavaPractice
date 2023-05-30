package cn.armand.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.armand.mapper.ArticleMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") 
public class SpringTest {
	
	@Autowired
	private ArticleMapper mapper;
	@Test
	public void testSpring() throws Exception {
		mapper.findAll().forEach(System.out::println);
	}
}
