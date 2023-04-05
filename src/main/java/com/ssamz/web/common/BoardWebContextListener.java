package com.ssamz.web.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BoardWebContextListener implements ServletContextListener {

    public BoardWebContextListener() {
    	System.out.println("===> BoardWebContextListner 积己");
    }
    
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContext 积己");
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("---> ServletContext 昏力");
    }
}
