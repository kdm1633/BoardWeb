<%@ page contentType="text/html; charset=UTF-8" isErrorPage="true"
	import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		* {
			text-align: center;
		}
	</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3><%= exception.getClass().getName() %> 발생!</h3>
	<% Date currentTime = new Date(); %>
	예외 발생 시간 : <%= currentTime.toString() %>
	<hr>
	<% StackTraceElement[] elements = exception.getStackTrace(); %>
	예외 위치 : <%= elements[0].toString() %>
</body>
</html>