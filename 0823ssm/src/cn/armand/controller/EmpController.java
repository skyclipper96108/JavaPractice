package cn.armand.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.armand.domain.Emp;
import cn.armand.domain.Empp;
import cn.armand.query.EmpQuery;
import cn.armand.service.IEmpService;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired // 前台 容器中有这个对象
	private IEmpService service;
	
	@RequestMapping("/findAll")
	public String findAll(Model model){
		List<Emp> emps = service.findAll();
		model.addAttribute("emps", emps);
		return "show";
	}
	@RequestMapping("/findByCondition")
	public String findByCondition(Model model, EmpQuery query){
		List<Emp> emps = service.findByCondition(query);
		model.addAttribute("emps", emps);
		System.out.println(query);
		// 回显
		model.addAttribute("emp", query);
		return "show";
	}
	@RequestMapping("/findAllp")
	@ResponseBody
	public List<Empp> findAllp(){
		return service.findAllp();
	}
	@RequestMapping("/del")
	@ResponseBody
	public String del(Integer eid) {
		try {
			service.del(eid);
			return "ok";
		}catch(Exception e) {
			return "failed";
		}
	}
	@RequestMapping("/save")
	@ResponseBody
	public String save(Empp empp) {
		try {
			service.save(empp);
			return "ok";
		}catch(Exception e) {
			return "failed";
		}
	}
	
}
