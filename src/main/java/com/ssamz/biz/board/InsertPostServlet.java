package com.ssamz.biz.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertPost.do")
public class InsertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PostVo post = new PostVo();
		post.setTitle(title);
		post.setWriter(writer);
		post.setContent(content);
		
		PostDao pd = new PostDao();
		pd.insertPost(post);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getPostList.do");
		dispatcher.forward(request, response);
	}
}
