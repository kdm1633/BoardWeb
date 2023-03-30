package com.ssamz.biz.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletePost.do")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		PostVo post = new PostVo();
		post.setSeq(seq);
		
		PostDao pd = new PostDao();
		pd.deletePost(post);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getPostList.do");
		dispatcher.forward(request, response);
	}
}
