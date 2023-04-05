package com.ssamz.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = { "*.do" })
public class TimeCheckFilter extends HttpFilter implements Filter {
    public TimeCheckFilter() {
        System.out.println("===> TimeCheckFilter ����");
    }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest)request;
		String uri = hreq.getRequestURI();
		String path = uri.substring(uri.lastIndexOf('/'));
		
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(path + "��û ó���� �ҿ�� �ð� : " + (endTime - startTime) + "ms(��)");
	}
}
