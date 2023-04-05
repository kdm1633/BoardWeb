package com.ssamz.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BoardWebContextListener implements ServletContextListener {

    public BoardWebContextListener() {
    	System.out.println("===> BoardWebContextListner ����");
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContext ����");
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContext ����");
    }
}
