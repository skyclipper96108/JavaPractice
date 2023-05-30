package cn.jacob.mybatisdao.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.jacob.mybatisdao.domain.Emp;
import cn.jacob.utils.MybatisUtil;

public class EmpDaoImpl implements IEmpDao {

	@Override
	public List<Emp> findAll() {
		SqlSession session = MybatisUtil.getSession();
		List<Emp> emps = session.selectList("cn.jacob.mybatisdao.dao.IEmpDao.findAll");
		return emps;
	}

	@Override
	public Emp findOne(Integer id) {
		SqlSession session = MybatisUtil.getSession();
		// ��һ����������sql��Ψһ��ʶ
		Emp emp = session.selectOne("cn.jacob.mybatisdao.dao.IEmpDao.findOne", id);
		return emp;
		
	}

	@Override
	public void addEmp(Emp emp) {
		SqlSession session = MybatisUtil.getSession();
		session.insert("cn.jacob.mybatisdao.dao.IEmpDao.addEmp", emp);
		session.commit();// 提交事务
	}

	@Override
	public void delEmp(Integer id) {
		SqlSession session = MybatisUtil.getSession();
		session.delete("cn.jacob.mybatisdao.dao.IEmpDao.addEmp", id);
		session.commit();// 提交事务
	}

	@Override
	public void update(Emp emp) {
		SqlSession session = MybatisUtil.getSession();
		session.update("cn.jacob.mybatisdao.dao.IEmpDao.updateEmp", emp);
		session.commit();// 提交事务
	}

}
