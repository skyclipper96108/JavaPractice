package sql.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.mysql.cj.jdbc.Driver;
@SuppressWarnings("unused")
public class jdbc_test {
	@Test
	public void testJDBC() throws SQLException {
		String sql = "create table Usr(id int not null auto_increment primary key,user_name varchar(20) not null default 'no_name');";
		/**
		 * 
		 
		// 1.��ȡ���ݿ�����
		Driver driver = new com.mysql.cj.jdbc.Driver();
		// 2.ע��Mysql����
		DriverManager.registerDriver(driver);
		*/
		
//		����ʡ��1��2�����Զ�ע����������ȡservices�������ļ�����ȡȫ�޶�����
		// 3.��ȡ����
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kevin?useUnicode=true&characterEncoding=utf8","root","123456");
		// 4.ͨ��Connection���Ӷ����ȡ��̬������statement
		Statement statement = conn.createStatement();
		// 5.ͨ��������ִ��SQL�������Ƿ�ɹ�
		//statement.execute(SQL) ִ��DDL�ķ���
		//statement.executeQueru(SQL) ִ��DQL�ķ���
		//statement.execute(SQL) ִ��DML�ķ���
		boolean b = statement.execute(sql);
		System.out.println(b);
		// 6.�ͷ���Դ �ȿ���أ����ȹ�
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
