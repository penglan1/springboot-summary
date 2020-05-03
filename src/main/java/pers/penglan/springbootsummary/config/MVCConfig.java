package pers.penglan.springbootsummary.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pers.penglan.springbootsummary.controller.interceptor.HandlerInterceptorDemo;

/**
 * @Author PENGL
 * 2020-04-26
 */
@SpringBootConfiguration
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorDemo()).addPathPatterns("/first/*");
    }
}
