package cn.armand.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.armand.util.Constant;

public class LoginInterceptor implements HandlerInterceptor {
	
	// 请求处理完成之后调用
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	//	在处理器之后执行
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		// 获取Session中绑定的登录对象并判断
		Object obj = req.getSession().getAttribute(Constant.USER_IN_SESSION);
		if(obj==null) {
//			resp.sendRedirect("WEB-INF/views/login.jsp");  //WEB-IN下的成员只能用转发
//			req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
			// 先重定向到处理器再由controller转发到登录页面
			resp.sendRedirect("/system/login");
			return false;
		}
		return true;
	}

}
