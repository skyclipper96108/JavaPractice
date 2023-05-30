package cn.armand.test;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.armand.bean.Mybean;
import cn.armand.bean.Tomato;

@SuppressWarnings("unused")
public class TestCase {
	private ClassPathXmlApplicationContext ac;

	@Test
	public void testTomato() throws Exception {
		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	    Tomato tomato = ac.getBean("tomato", Tomato.class);
		tomato.execute();
		Date now = ac.getBean("now", Date.class);
		System.out.println(now);
//		List list = ac.getBean("list", List.class);
//		System.out.println(list);
		Mybean mybean = ac.getBean("myBean",Mybean.class);
		System.out.println(mybean);
		
	}
}
