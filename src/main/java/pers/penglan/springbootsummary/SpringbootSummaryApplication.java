package pers.penglan.springbootsummary;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import pers.penglan.springbootsummary.servlet.Filter2;
import pers.penglan.springbootsummary.servlet.Servlet2;
import pers.penglan.springbootsummary.servlet.ServletContextListener2;

@SpringBootApplication
/*开启mybatis的mapper接口扫描，并生成对应的代理类*/
@MapperScan("pers.penglan.springbootsummary.mapper")
/*扫描servlet，并实例化*/
@ServletComponentScan("pers.penglan.springbootsummary.servlet")
@tk.mybatis.spring.annotation.MapperScan("pers.penglan.springbootsummary.tk.mapper")
public class SpringbootSummaryApplication {

    /**
     * 生成servlet的方法二
     * @return
     */
    @Bean
    public ServletRegistrationBean createServlet() {
        ServletRegistrationBean<Servlet2> registrationBean = new ServletRegistrationBean<>(new Servlet2());
        registrationBean.addUrlMappings("/servlet/s2");
        return registrationBean;
    }

    public static void main(String[] args) {
        System.out.println("要开始喽123");
        SpringApplication.run(SpringbootSummaryApplication.class, args);
    }

    /**
     * Filter生成方法二
     * @return
     */
    @Bean
    public FilterRegistrationBean createFilter() {
        FilterRegistrationBean<Filter2> filterRegistrationBean = new FilterRegistrationBean<>(new Filter2());
        filterRegistrationBean.addUrlPatterns("/servlet/*");
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean createListener() {
        ServletListenerRegistrationBean<ServletContextListener2> servletListenerRegistrationBean =
                new ServletListenerRegistrationBean<>(new ServletContextListener2());
        return servletListenerRegistrationBean;
    }
}
