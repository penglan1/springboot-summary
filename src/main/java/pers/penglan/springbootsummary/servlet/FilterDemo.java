package pers.penglan.springbootsummary.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter生成方法一
 * @Author PENGL
 * 2020-04-23
 */
@WebFilter(displayName = "filterDemo", urlPatterns = "/servlet/*")
public class FilterDemo extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo过滤器进入检查");
        chain.doFilter(request, response);
        System.out.println("FilterDemo过滤器退出检查");
    }
}
