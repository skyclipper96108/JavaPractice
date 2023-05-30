package cn.practice.file;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;
/*传统方式获取流是new创建的，为了避免获取不到配置文件，可以使用以下方法
 * 1. 通过当前类字节码文件的方式
 * 2. 通过类加载器的方式
 */
public class propertiesTest {
	@Test
	public void testProperties() throws Exception {
		Properties p = new Properties();
		try(
			 // ����һ��FileInputStream�����ļ�mysql.properties
//				FileInputStream fis = new FileInputStream("resources/mysql.properties");
				InputStream is = propertiesTest.class.getResourceAsStream("/mysql.properties");
				/*ͨ����ǰ��ļ�������ȡ
				 ��ǰ��.class.getClassLoader(); 
				 ����ʹ�õ�ǰ�̵߳����������Thread.currentThread().getContextClassLoarder();
				 classLoader.getResourceAsStream("�ļ�·��/�ļ���");
				 */
				
		){	// ����Properties��load��������Ӳ���ϵ��ļ�mysql.properties
			p.load(is);
			// ��properties�����е�����ȡ����
			String name = p.getProperty("user");
			String pwd = p.getProperty("password");
			System.out.print(name+":"+pwd);
		}catch (FileNotFoundException e) {
			System.out.println("�ļ�û���ҵ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO");
			e.printStackTrace();
		}
	}
}
