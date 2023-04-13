<%@ page contentType="text/html; charset=UTF-8"
	errorPage="../error/boardError.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<hr>
	<a href="index.jsp">홈</a>&nbsp;&nbsp;&nbsp;
	
	<c:if test="${sessionScope.user != null }">
		<a href="insertPostView.do">글등록</a>&nbsp;&nbsp;&nbsp;
		<a href="logout.do">로그아웃</a>
	</c:if>
	<c:if test="${user == null }">
		<a href="insertUserView.do">회원가입</a>&nbsp;&nbsp;&nbsp;
		<a href="loginView.do">로그인</a>
	</c:if>
	
	<hr><br>
</body>
</html>