package cn.jacob.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
	static SqlSessionFactory factory;
	// 静态代码块类加载时执行-执行一次
	static {
		try {
			// 加载主配置文件
			String resource = "mybatis.xml";
			Reader reader= Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSession() {
		return factory.openSession();
	}
}
