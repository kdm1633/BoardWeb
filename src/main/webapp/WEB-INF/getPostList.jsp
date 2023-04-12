<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ssamz.biz.board.PostVo" %>

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
	
	<%@ include file="../WEB-INF/layout/header.jsp" %>
	
	<%
		List<PostVo> postList = (List)request.getAttribute("postList");
	%>
	
	<div class="main">
		<!-- search -->
		<form method="post" action="/index.jsp">
			<table id="search">
				<tr>
					<td>
						<% String type = (String)session.getAttribute("type"); %>
						<select name="searchType">
							<option value="title" <%= (type.equals("title")) ? "selected" : "" %>>제목
							<option value="content" <%= (type.equals("content")) ? "selected" : "" %>>내용
						</select>
						<% String keyword = (String)session.getAttribute("keyword"); %>
						<input type="text" name="searchKeyword" value="<%= keyword %>"/>
						<input type="submit" value="검색"/>
					</td>
				</tr>
			</table>
		</form>
		
		<!-- post-list -->
		<table id="post-list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<% for (PostVo post : postList) { %>
				<tr>
					<td><%= post.getSeq() %></td>
					<td><a href="/getPost.do?seq=<%= post.getSeq() %>"><%= post.getTitle() %></a></td>
					<td><%= post.getWriter() %></td>
					<td><%= post.getRegDate() %></td>
					<td><%= post.getHit() %></td>
				</tr>
			<% } %>
		</table>
	</div>
	
	<%@ include file="../WEB-INF/layout/footer.jsp" %>
	
</body>
</html>