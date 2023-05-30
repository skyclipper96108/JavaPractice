package cn.kevincrud.dao;

import java.util.List;

import cn.kevincrud.domain.Emp;

public interface IEmpDao {

	List<Emp> findAll();

}
