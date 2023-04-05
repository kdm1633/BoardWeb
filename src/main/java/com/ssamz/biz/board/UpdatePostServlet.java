package com.ssamz.biz.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatePost.do")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostVo pv = new PostVo();
		pv.setSeq(seq);
		pv.setTitle(title);
		pv.setContent(content);
		
		PostDao pd = new PostDao();
		pd.updatePost(pv);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("getPostList.do");
		dispatcher.forward(request, response);
	}

}
