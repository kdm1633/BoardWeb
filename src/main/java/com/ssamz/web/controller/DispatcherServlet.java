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

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private MappingHandler mappingHandler;
	private ViewResolver viewResolver;
	
	public DispatcherServlet() {
		mappingHandler = new MappingHandler();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("/WEB-INF/board/");
		viewResolver.setSuffix(".jsp");
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		Controller controller = mappingHandler.getController(path);
		String viewName = controller.handleRequest(request, response);
		
		String view = null;
		if (viewName.contains(".do")) {
			view = viewName;
		}
		else {
			if (viewName.equals("index"))
				view = viewName + ".jsp";
			else
				view = viewResolver.getView(viewName);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
		requestDispatcher.forward(request, response);
	}
}
