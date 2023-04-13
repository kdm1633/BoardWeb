package com.ssamz.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.biz.user.UserDao;
import com.ssamz.biz.user.UserVo;

//@WebServlet("*.do")
public class DispatcherServletBackup extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		if (path.equals("/getPostList.do")) {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/getPostList.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/getPost.do")) {
			System.out.println("글조회 처리");
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			PostVo pv = new PostVo();
			pv.setSeq(seq);
			
			PostDao pd = new PostDao();
			PostVo post = pd.getPost(pv);
			
			request.setAttribute("post", post);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/getPost.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/insertPostView.do")) {
			System.out.println("글등록 화면으로 이동");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertPost.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/insertPost.do")) {
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
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/getPostList.do");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/updatePost.do")) {
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
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/getPostList.do");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/deletePost.do")) {
			System.out.println("글삭제 처리");
			
			int seq = Integer.parseInt(request.getParameter("seq"));

			PostVo pv = new PostVo();
			pv.setSeq(seq);
			
			PostDao pd = new PostDao();
			pd.deletePost(pv);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/getPostList.do");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/loginView.do")) {
			System.out.println("로그인 화면으로 이동");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserVo uv = new UserVo();
			uv.setId(id);
			
			UserDao ud = new UserDao();
			UserVo user = ud.getUser(uv);
			
			if (user!=null && user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				
				session.setAttribute("user", user);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/getPostList.do");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/loginView.do");
				dispatcher.forward(request, response);
			}
		}
		else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("/");
		}
		else if (path.equals("/insertUserView.do")) {
			System.out.println("회원가입 화면으로 이동");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/insertUser.jsp");
			dispatcher.forward(request, response);
		}
		else if (path.equals("/insertUser.do")) {
			System.out.println("회원가입 처리");
			
			UserVo uv = new UserVo();
			uv.setId(request.getParameter("id"));
			uv.setPassword(request.getParameter("password"));
			uv.setName(request.getParameter("name"));
			uv.setRole(request.getParameter("role"));
			
			UserDao ud = new UserDao();
			ud.insertUser(uv);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/");
			dispatcher.forward(request, response);
		}
	}
}
