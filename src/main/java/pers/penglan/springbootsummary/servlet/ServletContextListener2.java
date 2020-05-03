package pers.penglan.springbootsummary.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author PENGL
 * 2020-04-23
 */
public class ServletContextListener2 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener2启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
