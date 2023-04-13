package com.ssamz.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class DeletePostController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글삭제 처리");
		
		int seq = Integer.parseInt(request.getParameter("seq"));

		PostVo pv = new PostVo();
		pv.setSeq(seq);
		
		PostDao pd = new PostDao();
		pd.deletePost(pv);
		
		return "getPostList.do";
	}
}
