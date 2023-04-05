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
		System.out.println("---> UserVo ��ü�� ���ǿ� ��ϵ�");
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("---> UserVo ��ü�� ���ǿ��� ���ŵ�");
	}
}
