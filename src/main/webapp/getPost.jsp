<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssamz.biz.board.PostVo,
	com.ssamz.biz.board.PostDao" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/post.css">
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
	<%
		int seq = Integer.parseInt(request.getParameter("seq"));
	
		PostVo pv = new PostVo();
		pv.setSeq(seq);
		
		PostDao pd = new PostDao();
		PostVo post = pd.getPost(pv);
	%>

	<%@ include file="../layout/header.jsp"  %>
	
	<div class="main">
		<form method="post" action="updatePost_proc.jsp">
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
			<a href="deletePost_proc.jsp?seq=<%= post.getSeq() %>">삭제</a>
		<% } %>
	</div>
	
	<%@ include file="../layout/footer.jsp" %>
</body>
</html>