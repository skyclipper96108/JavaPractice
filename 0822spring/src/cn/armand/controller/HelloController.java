package cn.armand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("来了贝贝");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		// request.setAttribute("name","tom");效果一样
		mv.addObject("name","tom");
		mv.addObject("age","20");
		return mv; // 默认请求转发
	}

}
