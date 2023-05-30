package cn.zhangchujie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/go/b")
public class Bservlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("----B servlet重定向-------");
		// 重定向 不能携带参数 不能访问WEB-INF 地址栏改变防止数据重复提交
		resp.sendRedirect("http://www.baidu.com");
	}

}
