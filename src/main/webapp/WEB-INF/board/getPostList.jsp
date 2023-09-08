<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<style>
		.main {
			text-align: center;
		}
	</style>
	<link rel="stylesheet" href="css/board2.css">
	<meta charset="UTF-8">
	<title>게시판 프로그램</title>
</head>
<body>
	
	<%@ include file="/WEB-INF/layout/header.jsp" %>
	
	<fmt:setLocale value="${param.lang }" scope="session"/>
	
	<fmt:bundle basename="message.messageSource">
	<div class="main">
		<!-- search -->
		<form method="post" action="/getPostList.do">
			<table id="search">
				<tr>
					<td>
						<select name="searchType">
							<option value="title" <c:if test="${type == 'title'}">selected</c:if>>
								<fmt:message key="post.list.type.title"/>
							<option value="content" <c:if test="${type == 'content'}">selected</c:if>>
								<fmt:message key="post.list.type.content"/>
						</select>
						<input type="text" name="searchKeyword" value="${keyword }"/>
						<input type="submit" value="<fmt:message key="post.list.type.btn"/>"/>
					</td>
				</tr>
			</table>
		</form>
		
		<!-- post-list -->
		<table id="post-list">
			<tr>
				<th><fmt:message key="post.list.head.seq"/></th>
				<th><fmt:message key="post.list.head.title"/></th>
				<th><fmt:message key="post.list.head.writer"/></th>
				<th><fmt:message key="post.list.head.regDate"/></th>
				<th><fmt:message key="post.list.head.hit"/></th>
			</tr>
			<c:forEach var="post" items="${postList }">
			<tr>
				<td>${post.seq }</td>
				<td><a href="/getPost.do?seq=${post.seq }">${post.title }</a></td>
				<td>${post.writer }</td>
				<td>${post.regDate }</td>
				<td>${post.hit }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</fmt:bundle>
	
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
	
</body>
</html>