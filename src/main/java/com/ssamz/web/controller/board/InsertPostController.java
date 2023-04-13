package com.ssamz.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class InsertPostController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글등록 처리");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PostVo pv = new PostVo();
		pv.setTitle(title);
		pv.setWriter(writer);
		pv.setContent(content);
		
		PostDao pd = new PostDao();
		pd.insertPost(pv);
		
		return "getPostList.do";
	}
}
