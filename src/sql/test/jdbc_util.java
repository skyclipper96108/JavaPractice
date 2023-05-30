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
 * JDBC������
 * 1.��̬
 * 2.ʵ������ȡһ�����߶���ʹ�õ���ģʽ
 */
public class jdbc_util {
	//1.˽�л����췽��
	private jdbc_util() {}
	//2.ʹ�ö�ģʽ��������
	private static final jdbc_util INSTANCE = new jdbc_util();
	//3.�ṩһ������ľ�̬��
	public static jdbc_util getjdbc_util() {
		return INSTANCE;
	}
	//4. ��ȡ����
	public Connection getConnection() throws SQLException, IOException {
		//��ȡproperties����
		//1.����properties����
		Properties p =new Properties();
		//2.��ȡ��ǰ�̶߳���
		Thread thread = Thread.currentThread();
		//3.ͨ���̶߳����ȡ�������
		ClassLoader classLoader = thread.getContextClassLoader();
		//4.ͨ�����������ȡ�ֽ�������
		InputStream inputStream = classLoader.getResourceAsStream("mysql.properties");
		//5.����
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		//6.load������Դ
		p.load(bis);
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		Connection conn =DriverManager.getConnection(url, user, password);// ���Ӳ��������
		return conn;
	}
	//5.�ͷ���Դ �ȿ���أ����ȹأ��ж��Ƿ�Ϊ��
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
