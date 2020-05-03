package pers.penglan.springbootsummary.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author PENGL
 * 2020-04-23
 */
public class Filter2 extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2过滤器进入检查");
        chain.doFilter(req, res);
        System.out.println("Filter2过滤器进入检查");
    }
}
