package com.ssamz.web.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.user.UserDao;
import com.ssamz.biz.user.UserVo;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVo uv = new UserVo();
		uv.setId(id);
		
		UserDao ud = new UserDao();
		UserVo user = ud.getUser(uv);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (user != null) {
			if (user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("getPostList.do");
				dispatcher.forward(request, response);
			}
			else {
				out.println("��й�ȣ �����Դϴ�.<br>");
				out.println("<a href='/'>�ٽ� �α���</a>");
			}
		}
		else {
			out.println("���̵� �����Դϴ�.<br>");
			out.println("<a href='/'>�ٽ� �α���</a>");
		}
	}
}
