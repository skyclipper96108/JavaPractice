package cn.zhangchujie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestController extends HttpServlet {
	public TestController() {
		System.out.println("ү����");
	}
	// ʹ�ó�Ա������������̰߳�ȫ����
	public Integer num1;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("���ҿ�����");
		num1=Integer.parseInt(req.getParameter("num"));
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("<h1>"+num1+"</h1>");
	}
}
