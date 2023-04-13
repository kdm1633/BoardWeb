<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<style>
	.center {
		margin: 0 auto;
		text-align: center;
	}

	.login-table {
		margin: 0 auto;
		border: 1;
		cellpadding: 0;
		cellspacing: 0;
	}
	
	td.color {
		background-color: orange;
	}
</style>
<title>Login</title>
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp" %>

	<fmt:bundle basename="message.messageSource">
	<div class="center">
		<h1>LOGIN</h1>
		<img src="image/newYorker.png" width="90" height="100" alt="NewYorker">
		<br>
		<form method="post" action="login.do">
			<table class="login-table">
				<tr>
					<td class="color"><fmt:message key="user.login.id"/></td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td class="color"><fmt:message key="user.login.password"/></td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="<fmt:message key='user.login.loginBtn'/>"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	</fmt:bundle>
	
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>