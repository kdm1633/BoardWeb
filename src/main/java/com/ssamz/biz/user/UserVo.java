package com.ssamz.biz.user;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.Data;

@Data
public class UserVo implements HttpSessionBindingListener {
	private String id;
	private String password;
	private String name;
	private String role;
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVo °´Ã¼°¡ ¼¼¼Ç¿¡ µî·ÏµÊ");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVo °´Ã¼°¡ ¼¼¼Ç¿¡¼­ Á¦°ÅµÊ");
	}
}
