package com.ssamz.biz.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getPostList.do")
public class GetPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostVo pv = new PostVo();
		
		PostDao pd = new PostDao();
		List<PostVo> postList = pd.getPostList(pv);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='/css/board.css'>");
		out.println("<title>글 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='all'>");
		out.println("<h1>게시글 목록</h1>");
		out.println("<h3>손님 로그인 환영합니다");
		out.println("<a href='logout.do'>logout</a></h3>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<th>제목</th>");
		out.println("<th>작성자</th>");
		out.println("<th>내용</th>");
		out.println("<th>등록일</th>");
		out.println("<th>조회수</th>");
		out.println("</tr>");
		
		for (PostVo post : postList) {
			out.println("<tr>");
			out.println("<td>" + post.getSeq() + "</td>");
			out.println("<td><a href='getPost.do?seq=" + post.getSeq() + "'>" + post.getTitle() + "</a></td>");
			out.println("<td>" + post.getWriter() + "</td>");
			out.println("<td>" + post.getContent() + "</td>");
			out.println("<td>" + post.getRegDate() + "</td>");
			out.println("<td>" + post.getHit() + "</td>");
			out.println("</tr>");
		}
		
		out.println("</table><br>");
		out.println("<a href='insertPost.html'>글쓰기</a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
