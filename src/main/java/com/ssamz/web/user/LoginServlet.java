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
				session.setMaxInactiveInterval(300);
				session.setAttribute("userId", user.getId());
				session.setAttribute("userName", user.getName());
				session.setAttribute("userRole", user.getRole());
				
				ServletContext context = getServletContext();
				context.setAttribute("welcomeMessage", "님 환영합니다.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("getPostList.do");
				dispatcher.forward(request, response);
			}
			else {
				out.println("비밀번호 오류입니다.<br>");
				out.println("<a href='/'>다시 로그인</a>");
			}
		}
		else {
			out.println("아이디 오류입니다.<br>");
			out.println("<a href='/'>다시 로그인</a>");
		}
	}
}
