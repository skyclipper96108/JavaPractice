package cn.armand.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.armand.domain.Emp;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/form1")
	public void form1(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("pwd"));
	}
	@RequestMapping("/form2")// 通过参数名获取请求数据，但是参数名必须和表单的名称一致
	public void form1(String name, String pwd) {
		System.out.println(name);
		System.out.println(pwd);
	}
	@RequestMapping("/form3")// 通过对象获取多个参数
	public void form3(Emp emp) {
		System.out.println(emp);
	}
	@RequestMapping("/form4/{id}/{username}")// 通过路径接受参数，符合reatful风格
	public void form4(@PathVariable("id")Integer id,@PathVariable("username")String name) {
		System.out.println(id);
		System.out.println(name);
	}
	@RequestMapping("/form5") // 返回信息的第一种方式
	public ModelAndView form5() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message5", "success");
		mv.setViewName("jsp/model2"); // 请求转发
		return mv;
	}
	@RequestMapping("/form6") // 使用modelAndView对象
	public String form6(Model model) {
		model.addAttribute("message","success");
		return "jsp/model2"; // 配置视图解析器转发效率较高
		// 重定向不会经过视图解析器 return redirect: /jsp/model2.jsp
	}
}
