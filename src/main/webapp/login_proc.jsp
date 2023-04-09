<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.user.UserVo,
	com.ssamz.biz.user.UserDao" %>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVo uv = new UserVo();
	uv.setId(id);
	
	UserDao ud = new UserDao();
	UserVo user = ud.getUser(uv);
	
	if (user != null) {
		if (user.getPassword().equals(password)) {
			session.setAttribute("user", user);
			
			response.sendRedirect("/index.jsp");
		}
		else {
			out.println("비밀번호 오류입니다.<br>");
			out.println("<a href='/login.jsp'>다시 로그인</a>");
		}
	}
	else {
		out.println("아이디 오류입니다.<br>");
		out.println("<a href='/login.jsp'>다시 로그인</a>");
	}
%>