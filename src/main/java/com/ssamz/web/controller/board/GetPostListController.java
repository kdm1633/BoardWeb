package com.ssamz.web.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class GetPostListController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글목록 처리");
		
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		if (searchType == null) searchType = "title";
		if (searchKeyword == null) searchKeyword = "";
		
		HttpSession session = request.getSession();
		session.setAttribute("type", searchType);
		session.setAttribute("keyword", searchKeyword);
	
		PostVo pv = new PostVo();
		pv.setSearchType(searchType);
		pv.setSearchKeyword(searchKeyword);
		
		PostDao pd = new PostDao();
		List<PostVo> postList = pd.getPostList(pv);
		
		request.setAttribute("postList", postList);
		
		return "getPostList";
	}
}
