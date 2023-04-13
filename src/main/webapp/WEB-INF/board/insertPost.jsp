<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/post.css">
	<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp" %>

	<div class="all">
		<form method="post" action="insertPost.do">
			<table>
				<tr>
					<td class="td-name">제목</td>
					<td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td class="td-name">작성자</td>
					<td><input type="text" name="writer" size="10"/></td>
				</tr>
				<tr>
					<td class="td-name">내용</td>
					<td><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" class="td-submit"><input type="submit" value="등록"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>