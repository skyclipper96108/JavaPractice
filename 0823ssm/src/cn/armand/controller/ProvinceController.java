package cn.armand.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.armand.domain.City;
import cn.armand.domain.Province;

@Controller
@RequestMapping("/get")
public class ProvinceController{
	//1. 获取所有的省份-List
	//2. 将list集合转成json格式的字符串
	//3. 使用流输出
	
	@ResponseBody
	@RequestMapping("/province")
	public List<Province> getProvinces() {	
		List<Province> provinces = Province.getAllProvince();
		return provinces;
	}
	@ResponseBody
	@RequestMapping("/city")
	public List<City> getCity(HttpServletRequest req) {
		System.out.println(req.getParameter("id"));
		long id = Long.parseLong(req.getParameter("id"));
		List<City> cities = City.getCityByProvinceId(id);
		return cities;
	}
	
}
