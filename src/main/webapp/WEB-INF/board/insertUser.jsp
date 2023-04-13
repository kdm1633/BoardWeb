<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/signup.css">
	<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/layout/header.jsp" %>

	<form method="post" action="/insertUser.do">
		<table>
			<tr>
				<td class="name-td">아이디</td>
				<td><input type="text" name="id" size="12"/></td>
			</tr>
			<tr>
				<td class="name-td">비밀번호</td>
				<td><input type="password" name="password" size="12"/></td>
			</tr>
			<tr>
				<td class="name-td">이름</td>
				<td><input type="text" name="name" size="30"/></td>
			</tr>
			<tr>
				<td class="name-td">권한</td>
				<td>
					<input type="radio" name="role" value="USER" checked/>USER
					<input type="radio" name="role" value="ADMIN"/>ADMIN
				</td>
			</tr>
			<tr>
				<td class="name-td">자기소개</td>
				<td><textarea name="selfInfo" rows="5" cols="30">자기소개를 입력하세요.</textarea></td>
			</tr>
			<tr>
				<td class="name-td">언어</td>
				<td>
					<input type="checkbox" name="languages" value="C" checked>C
					<input type="checkbox" name="languages" value="Python">Python
					<input type="checkbox" name="languages" value="Java" checked>Java
					<input type="checkbox" name="languages" value="Go">Go
					<input type="checkbox" name="languages" value="Javascript">Javascript
				</td>
			</tr>
			<tr>
				<td class="name-td">나이</td>
				<td>
					<select name="age">
						<option>--선택--
						<option value="10대">10대
						<option value="20대">20대
						<option value="30대">30대
						<option value="40대">40대
						<option value="50대">50대
						<option value="60대 이상">60대 이상
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="signup-btn">
					<input type="submit" value="회원가입"/>
					<input type="reset" value="재설정"/>
				</td>
			</tr>
		</table>
	</form>
	
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
	
</body>
</html>