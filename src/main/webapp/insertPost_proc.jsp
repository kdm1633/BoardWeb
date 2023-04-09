<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.board.PostVo,
	com.ssamz.biz.board.PostDao" %>

<%
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	PostVo pv = new PostVo();
	pv.setTitle(title);
	pv.setWriter(writer);
	pv.setContent(content);
	
	PostDao pd = new PostDao();
	pd.insertPost(pv);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
%>