<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.board.PostVo,
	com.ssamz.biz.board.PostDao" %>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	PostVo pv = new PostVo();
	pv.setSeq(seq);
	pv.setTitle(title);
	pv.setContent(content);
	
	PostDao pd = new PostDao();
	pd.updatePost(pv);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
%>