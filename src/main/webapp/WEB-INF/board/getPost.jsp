<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.board.PostVo" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/post.css">
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<%
		PostVo post = (PostVo)request.getAttribute("post");
	%>

	<%@ include file="/WEB-INF/layout/header.jsp" %>
	
	<div class="main">
		<form method="post" action="updatePost.do">
			<input type="hidden" name="seq" value="<%= post.getSeq() %>"/>
			<table>
					<tr>
						<td class="td-name">제목</td>
						<td><input type="text" name="title" value="<%= post.getTitle() %>"/></td>
					</tr>
					<tr>
						<td class="td-name">작성자</td>
						<td><input type="text" name="writer" value="<%= post.getWriter() %>" size="10"/></td>
					</tr>
					<tr>
						<td class="td-name">내용</td>
						<td><textarea name="content" cols="40" rows="10"><%= post.getContent() %></textarea></td>
					</tr>
					<tr>
						<td class="td-name">등록일</td>
						<td><%= post.getRegDate() %></td>
					</tr>
					<tr>
						<td class="td-name">조회수</td>
						<td><%= post.getHit() %></td>
					</tr>
					<tr>
						<td colspan="2" class="td-submit"><input type="submit" value="수정"/></td>
					</tr>
				</table>
		</form>
		<br>
		<% if (user!=null && user.getRole().equals("ADMIN")) { %>
			<a href="deletePost.do?seq=<%= post.getSeq() %>">삭제</a>
		<% } %>
	</div>
	
	<%@ include file="/WEB-INF/layout/footer.jsp" %>
</body>
</html>