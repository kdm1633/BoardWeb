package com.ssamz.biz.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getPost.do")
public class GetPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		
		PostVo pv = new PostVo();
		pv.setSeq(Integer.parseInt(seq));
		
		PostDao pd = new PostDao();
		PostVo post = pd.getPost(pv);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='/css/post.css'>");
		out.println("<title>�� ��</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='all'>");
		out.println("<h1>�� ��</h1>");
		out.println("<h3><a href='logout.do'>logout</a></h3>");
		out.println("<form method='post' action='updatePost.do'>");
		out.println("<input type='hidden' name='seq' value='" + post.getSeq() + "'/>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td class='td-name'>����</td>");
		out.println("<td><input type='text' name='title' value='" + post.getTitle() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td class='td-name'>�ۼ���</td>");
		out.println("<td><input type='text' name='writer' value='" + post.getWriter() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td class='td-name'>����</td>");
		out.println("<td><textarea name='content' rows='10' cols='40'>" + post.getContent() + "</textarea></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td class='td-name'>�����</td>");
		out.println("<td>" + post.getRegDate() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td class='td-name'>��ȸ��</td>");
		out.println("<td>" + post.getHit() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2'><input type='submit' value='�ۼ���'/></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<a href='insertPost.html'>�۵��</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='deletePost.do?seq=" + post.getSeq() + "'>�ۻ���</a>&nbsp;&nbsp;&nbsp;");
		out.println("<a href='getPostList.do'>�۸��</a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}