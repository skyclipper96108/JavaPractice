package cn.armand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.armand.domain.Emp;
import cn.armand.domain.Empp;
import cn.armand.mapper.EmpMapper;
import cn.armand.query.EmpQuery;
import cn.armand.service.IEmpService;

@Service
public class EmpServiceImpl implements IEmpService {
	@Resource
	private EmpMapper mapper;
	@Override
	public List<Emp> findAll() {
		return mapper.findAll();
	}
	@Override
	public List<Emp> findByCondition(EmpQuery query) {
		return mapper.findByCondition(query);
	}
	@Override
	public List<Empp> findAllp() {
		return mapper.findAllp();
	}
	@Override
	public void del(Integer eid) {
		mapper.delEmpp(eid);
		
	}
	@Override
	public void save(Empp empp) {
		if(empp.getEid()==null)mapper.addEmpp(empp);
		else mapper.updateEmpp(empp);
	}
}
