package com.ssamz.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.web.controller.Controller;

public class InsertUserViewController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ȸ������ ȭ������ �̵�");
		
		return "insertUser";
	}
}
