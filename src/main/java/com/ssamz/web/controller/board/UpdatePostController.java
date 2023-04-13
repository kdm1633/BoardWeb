package com.ssamz.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class UpdatePostController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글수정 처리");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostVo pv = new PostVo();
		pv.setSeq(seq);
		pv.setTitle(title);
		pv.setContent(content);
		
		PostDao pd = new PostDao();
		pd.updatePost(pv);
		
		return "getPostList.do";
	}
}
