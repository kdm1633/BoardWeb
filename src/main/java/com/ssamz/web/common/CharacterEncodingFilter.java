package com.ssamz.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

@WebFilter(urlPatterns={ 
				"/insertPost.do", 
				"/insertUser.do", 
				"/updatePost.do", 
				"/getPostList.do"},
		initParams=@WebInitParam(name="boardEncoding", value="UTF-8"))
public class CharacterEncodingFilter extends HttpFilter implements Filter {
	private String encoding;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("boardEncoding");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}
}
