package com.ssamz.web.controller.user;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.user.UserDao;
import com.ssamz.biz.user.UserVo;
import com.ssamz.web.controller.Controller;

public class LoginController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserVo uv = new UserVo();
		uv.setId(id);
		
		UserDao ud = new UserDao();
		UserVo user = ud.getUser(uv);
		
		if (user!=null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			return "/getPostList.do";
		}
		else
			return "/loginView.do";
	}
}
