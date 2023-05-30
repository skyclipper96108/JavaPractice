package cn.kevincrud.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kevincrud.dao.IEmpDao;
import cn.kevincrud.domain.Emp;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public List<Emp> findAll() {
		
		
		Connection conn = null;
		try {
			// 1.加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.获取连接
			conn = DriverManager.getConnection("jdbc:mysql:///kevin","root","123456");
			// 3.获取编译对象
			PreparedStatement ps = conn.prepareStatement("select * from jst1");
			// 4.ִ执行sql语句
			ResultSet rs = ps.executeQuery();
			List<Emp> emps = new ArrayList<>();
			while(rs.next()) {
				// 循环拿到rs中每一个对象的每一个值ֵ
				Integer id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				Emp emp = new Emp(id,username, password);
				emps.add(emp);
			}
			return emps;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 5.释放连接
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
				}
		}
		return null;
	}

}
