package cn.armand.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //创建对象 不需要写bean 要求：扫描包路径
public class HiController {
	
	@Autowired // 从spring容器中自动获取Date类型对象并给字段赋值
	private Date dt;
	
	@RequestMapping("/date")
	public ModelAndView date() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("name","date");
		mv.addObject("age",dt);
		return mv; // 默认请求转发
	}
	
	@RequestMapping("/save") // 匹配、映射请求。要求：开启spring的mvc支持
	public void save() {
		//获取请求参数、向页面传值、跳转方式
		System.out.println("我存了");
	}
}
