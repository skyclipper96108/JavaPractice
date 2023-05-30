package cn.armand.test;

import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.armand.bean.Mybean;
import cn.armand.dao.IEmpDao;

// Spring管理对象默认是单例模式 可以在xml配置scope="prototype" 单例的对象才会调用销毁
@RunWith(SpringJUnit4ClassRunner.class) //开启spring测试 自动创建容器
@ContextConfiguration("classpath:applicationContext.xml") 
// 默认xml名字是当前包下的 类-Context 
public class SpringTest {
	
	@Autowired // 从spring容器中自动获取Date类型对象并给字段赋值
	private Date date;
	/**
	 * @Autowired注解是按照类型(byType)装配依赖对象
	 * 可以使用@Qualifier去指定名字
	 * @Resource默认按照(ByName)自动注入
	 */
	@Resource // 从spring容器中自动获取对象
	private Mybean myBean;
	
	@Autowired
	private IEmpDao dao;
	
	@Test
	public void testSpring() throws Exception {
		System.out.println(date);
		System.out.println(myBean);
		System.out.println(dao);
	}
}
