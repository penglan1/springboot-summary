package pers.penglan.springbootsummary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用Spring boot的配置
 * <strong>配置内容必须位于spring boot 的 application配置文件中</strong>
 *
 * <p>注意：使用该注解时，如果有报错说没有注解处理器，则需要添加注解的处理器</p>
 *
 * <p>其实，还有更加优雅的方式，哈哈</p>
 *
 * @Author PENGL
 * 2020-04-24
 */
@ConfigurationProperties(prefix = "spring.datasource")
public class SBootJDBCProperties {
    private String driverClassName;

    private String jdbcUrl;

    private String user;

    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
