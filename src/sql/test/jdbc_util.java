package sql.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/*
 * JDBC工具类
 * 1.静态
 * 2.实例：获取一个工具对象，使用单例模式
 */
public class jdbc_util {
	//1.私有化构造方法
	private jdbc_util() {}
	//2.使用恶汉模式创建对象
	private static final jdbc_util INSTANCE = new jdbc_util();
	//3.提供一个公告的静态的
	public static jdbc_util getjdbc_util() {
		return INSTANCE;
	}
	//4. 获取链接
	public Connection getConnection() throws SQLException, IOException {
		//获取properties配置
		//1.创建properties对象
		Properties p =new Properties();
		//2.获取当前线程对象
		Thread thread = Thread.currentThread();
		//3.通过线程对象获取类加载器
		ClassLoader classLoader = thread.getContextClassLoader();
		//4.通过类加载器获取字节输入流
		InputStream inputStream = classLoader.getResourceAsStream("mysql.properties");
		//5.缓冲
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		//6.load加载资源
		p.load(bis);
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		Connection conn =DriverManager.getConnection(url, user, password);// 解决硬编码问题
		return conn;
	}
	//5.释放资源 先开后关，后开先关，判断是否为空
	public void close(Connection conn, Statement statement) {
		try {
			if(statement!=null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
					if(conn!=null) {
						conn.close();
					}
			}catch (Exception e2){
				e2.printStackTrace();
				}
			}	
	}

}
