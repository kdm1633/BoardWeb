package com.ssamz.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDao;
import com.ssamz.biz.user.UserVo;
import com.ssamz.web.controller.Controller;

public class InsertUserController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		UserVo uv = new UserVo();
		uv.setId(id);
		uv.setPassword(password);
		uv.setName(name);
		uv.setRole(role);
		
		UserDao ud = new UserDao();
		ud.insertUser(uv);
		
		return "index";
	}
}
