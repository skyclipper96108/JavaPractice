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
// @WebServlet("/system/*") 只要是/system/下的请求都可以匹配上
@WebServlet("/emp/*")
public class EmpController extends HttpServlet {
	IEmpService service = new EmpServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");// 处理post请求的乱码
		// 1.匹配请求并接受请求参数
		String uri = req.getRequestURI();
		if(uri.indexOf("list")!=-1) {
			// uri中包含list的字符串 就是
			doList(req, resp);
		}else if(uri.indexOf("del")!=-1) {
			doDel(req,resp);
		}
	}
	private void doDel(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("删除成功");
		
	}
	private void doList(HttpServletRequest req, HttpServletResponse resp) {
		// 2.调用service代码处理请求
		List<Emp> emps = service.findAll();
		// 3. 跳转响应
		System.out.println(emps);
		req.setAttribute("emps", emps);
		try {
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			System.out.println("查询成功");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
