package pers.penglan.springbootsummary.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @Author PENGL
 * 2020-04-21
 */
@SpringBootConfiguration
public class CommonBeanFactory {
    @Bean
    public Logger getLogger() {
        return LogManager.getLogger("sbs");
    }

}
