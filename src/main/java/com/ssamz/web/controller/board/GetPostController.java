package com.ssamz.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class GetPostController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("����ȸ ó��");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		PostVo pv = new PostVo();
		pv.setSeq(seq);
		
		PostDao pd = new PostDao();
		PostVo post = pd.getPost(pv);
		
		request.setAttribute("post", post);
		
		return "getPost";
	}
}
