package pers.penglan.springbootsummary.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author PENGL
 * 2020-04-24
 */
@Configuration
//@EnableConfigurationProperties(SBootJDBCProperties.class)
public class SBootPropertiesConfig {
    /*@Bean
    public ComboPooledDataSource createDataSources(SBootJDBCProperties sBootJDBCProperties) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(sBootJDBCProperties.getDriverClassName());
        dataSource.setJdbcUrl(sBootJDBCProperties.getJdbcUrl());
        dataSource.setUser(sBootJDBCProperties.getUser());
        dataSource.setPassword(sBootJDBCProperties.getPassword());
        return dataSource;
    }*/

    /**
     * 更加优雅的方式进行属性配置
     */
    /*因暂时要测试Hikari连接池，所以将此处注释掉*/
    /*@Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public ComboPooledDataSource createDataSource() {
        return new ComboPooledDataSource();
    }*/
}
