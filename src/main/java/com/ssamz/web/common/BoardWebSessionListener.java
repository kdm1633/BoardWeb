package com.ssamz.web.common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class BoardWebSessionListener implements HttpSessionAttributeListener {
	public BoardWebSessionListener() {
		System.out.println("===> BoardWebSessionListener ����");
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("---> ���ǿ� ������ �����");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("---> ���ǿ� ��ϵ� ������ ���");
	}
	
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("---> ���ǿ� ��ϵ� ������ ������");
	}
}
