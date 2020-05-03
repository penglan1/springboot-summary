package pers.penglan.springbootsummary.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

/**
 * 使用PropertiesSource注解指定外部配置文件
 *
 * @Author PENGL
 * 2020-04-24
 */
//@Configuration
//@PropertySource("classpath:config/jdbc.properties")
public class JDBCProperties {
    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String user;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public ComboPooledDataSource createDataSources() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClassName);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
