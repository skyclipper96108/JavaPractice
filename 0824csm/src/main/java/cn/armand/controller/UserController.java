package cn.armand.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.armand.domain.User;
import cn.armand.service.IUserService;
import cn.armand.util.Constant;

@Controller
@RequestMapping("/system")
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String toLogin() {
		return "login";
		}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> Login(User user, Integer remember, HttpServletRequest req, HttpServletResponse resp) {
		Map<String,Object> map = new HashMap<>();
		try {
			User dbUser = service.findByUser(user);	
			//登录成功，将登录信息放在session中
			req.getSession().setAttribute(Constant.USER_IN_SESSION, dbUser);
			//System.out.print(session);
			map.put("success", true);
			// 登录成功则判断remember
			if(remember!=null) {
				Cookie c1 = new Cookie(Constant.USERNAME, dbUser.getUsername());
				Cookie c2 = new Cookie(Constant.PASSWORD, dbUser.getPassword());
				c1.setMaxAge(24*60*60);//设置1天有效
				c2.setMaxAge(24*60*60);
				c1.setPath("/"); //设置根路径有效
				c2.setPath("/");
				resp.addCookie(c1);
				resp.addCookie(c2);
			}else {
				Cookie[] cookies = req.getCookies();
				for(Cookie c: cookies) {
					if(c.getName().equals(Constant.USERNAME) || c.getName().equals(Constant.PASSWORD)) {
						c.setMaxAge(0);
						c.setPath("/");
						resp.addCookie(c); // 删除已经存在的cookie 要以替换的方式才能删掉 // 重复加名字一样的cookie就是修改
					}
				}
			}
			
			
		} catch (Exception e) {
			map.put("success", false);
			map.put("msg", e.getMessage());
		}
		return map;
	}
	/**
	 * 注销的请求
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String toLogout(HttpSession session) {
		// 登出销毁session
		session.invalidate();
		return "login";
		}
}		

