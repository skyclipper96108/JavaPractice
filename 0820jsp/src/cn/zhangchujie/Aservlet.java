package cn.zhangchujie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/go/a")
public class Aservlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求转发地址栏不会发生改变，重定向地址栏发生改变
		System.out.println("----A servlet请求转发-------");
		req.getRequestDispatcher("/go/b").forward(req, resp);
		// 可以通过请求转发访问到web-inf里的资源
	}

	
	
	

}
