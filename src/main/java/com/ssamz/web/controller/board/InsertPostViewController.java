package com.ssamz.web.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.board.PostDao;
import com.ssamz.biz.board.PostVo;
import com.ssamz.web.controller.Controller;

public class InsertPostViewController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글등록 화면으로 이동");
		
		return "insertPost";
	}
}
