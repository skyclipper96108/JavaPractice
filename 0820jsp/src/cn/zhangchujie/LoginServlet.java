package cn.zhangchujie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. ���ղ���
 * 2. ����ҵ���߼�
 * 3. ��ת������ת������Я���������ض��򣺲���Я�����������������
 */
@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������ı����ʽ
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String addr = req.getRemoteAddr();
		System.out.println(addr);
		// ���÷��ض���ı����ʽ�ͷ�������
//		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter writer = resp.getWriter();
		if("123".equals(username)&&"123".equals(password)) {
			System.out.println("��½�ɹ�");
			writer.print("��¼�ɹ�");
//			resp.sendRedirect("main.html");
		}else {
			System.out.println("��¼ʧ��");
			writer.print("��¼ʧ��");
			req.getRequestDispatcher("login.html").forward(req, resp);
		}
		
	}
}
