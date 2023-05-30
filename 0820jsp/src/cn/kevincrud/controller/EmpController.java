package cn.kevincrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kevincrud.service.IEmpService;
import cn.kevincrud.service.impl.EmpServiceImpl;
import cn.kevincrud.domain.Emp;
@SuppressWarnings("serial")

// @WebServlet(urlPattern={"/test1","/test2"}, )
// @WebServlet("/system/*") ֻҪ��/system/�µ����󶼿���ƥ����
@WebServlet("/emp/*")
public class EmpController extends HttpServlet {
	IEmpService service = new EmpServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");// ����post���������
		// 1.ƥ�����󲢽����������
		String uri = req.getRequestURI();
		if(uri.indexOf("list")!=-1) {
			// uri�а���list���ַ��� ����
			doList(req, resp);
		}else if(uri.indexOf("del")!=-1) {
			doDel(req,resp);
		}
	}
	private void doDel(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("ɾ���ɹ�");
		
	}
	private void doList(HttpServletRequest req, HttpServletResponse resp) {
		// 2.����service���봦������
		List<Emp> emps = service.findAll();
		// 3. ��ת��Ӧ
		System.out.println(emps);
		req.setAttribute("emps", emps);
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			System.out.println("��ѯ�ɹ�");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
