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
	<%@ include file="../layout/header.jsp" %>

	<div class="center">
		<h1>LOGIN</h1>
		<img src="image/newYorker.png" width="90" height="100" alt="NewYorker">
		<br>
		<form method="post" action="login_proc.jsp">
			<table class="login-table">
				<tr>
					<td class="color">Id</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td class="color">Password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Login"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="../layout/footer.jsp" %>
</body>
</html>