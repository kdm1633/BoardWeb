<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.board.PostVo,
	com.ssamz.biz.board.PostDao" %>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));

	PostVo pv = new PostVo();
	pv.setSeq(seq);
	
	PostDao pd = new PostDao();
	pd.deletePost(pv);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
	dispatcher.forward(request, response);
%>