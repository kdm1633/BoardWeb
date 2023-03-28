package com.ssamz.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDao;
import com.ssamz.biz.user.UserVo;

public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		String selfInfo = request.getParameter("selfInfo");
		String[] languages = request.getParameterValues("languages");
		String age = request.getParameter("age");
		
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + password);
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + role);
		System.out.println("�ڱ�Ұ� : " + selfInfo);
		System.out.println("��� ����");
		for (String language : languages)
			System.out.print(language + ", ");
		System.out.println();
		System.out.println("���� : " + age);
		
		// DB connection
		
		UserVo vo = new UserVo();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		UserDao dao = new UserDao();
		dao.insertUser(vo);
		
		response.sendRedirect("login.html");
	}
}