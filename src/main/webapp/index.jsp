<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ssamz.biz.board.PostDao" %>
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
	
	<%@ include file="../layout/header.jsp" %>
	
	<%
		PostVo pv = new PostVo();
		pv.setSearchType("title");
		pv.setSearchKeyword("");
		
		PostDao pd = new PostDao();
		List<PostVo> postList = pd.getPostList(pv);
	%>
	
	<div class="main">
		<!-- search -->
		<form method="post" action="getPostList.do">
			<table id="search">
				<tr>
					<td>
						<select name="searchType">
							<option value="title">제목
							<option value="content">내용
						</select>
						<input type="text" name="searchKeyword"/>
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
					<td><a href="/getPost.do?seq=<%= post.getSeq()%>"><%= post.getTitle() %></a></td>
					<td><%= post.getWriter() %></td>
					<td><%= post.getRegDate() %></td>
					<td><%= post.getHit() %></td>
				</tr>
			<% } %>
		</table>
	</div>
	
	<%@ include file="../layout/footer.jsp" %>
	
</body>
</html>