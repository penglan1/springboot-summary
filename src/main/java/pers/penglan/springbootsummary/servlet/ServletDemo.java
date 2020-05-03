package pers.penglan.springbootsummary.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet生成方式一
 * @Author PENGL
 * 2020-04-23
 */
@WebServlet(name = "servletDemo", urlPatterns = "/servlet/s1")
public class ServletDemo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h1>这个是Spring boot里整合的servlet</h1>");
    }
}
