<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.user.UserVo,
	com.ssamz.biz.user.UserDao" %>

<%
	UserVo uv = new UserVo();
	uv.setId(request.getParameter("id"));
	uv.setPassword(request.getParameter("password"));
	uv.setName(request.getParameter("name"));
	uv.setRole(request.getParameter("role"));
	
	UserDao ud = new UserDao();
	ud.insertUser(uv);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/");
	dispatcher.forward(request, response);
%>