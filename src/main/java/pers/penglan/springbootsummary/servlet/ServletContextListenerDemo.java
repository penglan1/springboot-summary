package pers.penglan.springbootsummary.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author PENGL
 * 2020-04-23
 */
@WebListener
public class ServletContextListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListenerDemo启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
