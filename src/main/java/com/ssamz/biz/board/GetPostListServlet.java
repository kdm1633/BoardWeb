package com.ssamz.biz.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getPostList.do")
public class GetPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		if (userId == null)
			response.sendRedirect("/");
		String userName = (String)session.getAttribute("userName");
		
		ServletContext context = getServletContext();
		String encoding = context.getInitParameter("boardEncoding");
		request.setCharacterEncoding(encoding);
		
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		if (searchType == null) searchType= "title";
		if (searchKeyword == null) searchKeyword = "";
		
		session.setAttribute("type", searchType);
		session.setAttribute("keyword", searchKeyword);
		String type = (String)session.getAttribute("type");
		String keyword = (String)session.getAttribute("keyword");
		
		PostVo pv = new PostVo();
		pv.setSearchType(searchType);
		pv.setSearchKeyword(searchKeyword);
		
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
		out.println("<h3>" + userName + "님 로그인 환영합니다");
		out.println("<a href='logout.do'>logout</a></h3>");
		
		out.println("<!-- 검색 시작 -->");
		out.println("<form method='post' action='getPostList.do'>");
		out.println("<table id='search'>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<select name='searchType'>");
		if (type.equals("title"))
			out.println("<option value='title' selected>제목");
		else
			out.println("<option value='title'>제목");
		if (type.equals("content"))
			out.println("<option value='content' selected>내용");
		else
			out.println("<option value='content'>내용");
		out.println("</select>");
		out.println("<input type='text' name='searchKeyword' value='" + keyword + "'/>");
		out.println("<input type='submit' value='검색'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<!-- 검색 종료 -->");
		
		out.println("<table id='post-list'>");
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
