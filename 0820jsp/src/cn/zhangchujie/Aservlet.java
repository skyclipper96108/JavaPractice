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
		// ����ת����ַ�����ᷢ���ı䣬�ض����ַ�������ı�
		System.out.println("----A servlet����ת��-------");
		req.getRequestDispatcher("/go/b").forward(req, resp);
		// ����ͨ������ת�����ʵ�web-inf�����Դ
	}

	
	
	

}
