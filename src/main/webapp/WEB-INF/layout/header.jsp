<%@ page contentType="text/html; charset=UTF-8"
	errorPage="errors/boardError.jsp" %>
<%@ page import="com.ssamz.biz.user.UserVo" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<hr>
	<a href="index.jsp">홈</a>&nbsp;&nbsp;&nbsp;
	
	<%
		UserVo user = (UserVo)session.getAttribute("user");
	%>
	<% if (user != null) { %>
		<a href="insertPostView.do">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="logout.do">로그아웃</a>
	<% } else { %>
		<a href="insertUserView.do">회원가입</a>&nbsp;&nbsp;&nbsp;
		<a href="loginView.do">로그인</a>
	<% } %>
	
	<hr><br>
</body>
</html>