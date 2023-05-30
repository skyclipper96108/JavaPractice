package cn.zhangchujie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestController extends HttpServlet {
	public TestController() {
		System.out.println("爷来了");
	}
	// 使用成员变量可能造成线程安全问题
	public Integer num1;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("让我康康！");
		num1=Integer.parseInt(req.getParameter("num"));
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("<h1>"+num1+"</h1>");
	}
}
