package cn.zhangchujie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 接收参数
 * 2. 处理业务逻辑
 * 3. 跳转（请求转发：可携带参数、重定向：不可携带参数、请求包含）
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求对象的编码格式
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String addr = req.getRemoteAddr();
		System.out.println(addr);
		// 设置返回对象的编码格式和返回类型
//		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		if("123".equals(username)&&"123".equals(password)) {
			System.out.println("登陆成功");
			writer.print("登录成功");
//			resp.sendRedirect("main.html");
		}else {
			System.out.println("登录失败");
			writer.print("登录失败");
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
		
	}
}
