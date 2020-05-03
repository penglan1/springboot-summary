package pers.penglan.springbootsummary.controller;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.penglan.springbootsummary.config.JDBCProperties;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author PENGL
 * 2020-04-24
 */
@RequestMapping("/config")
@RestController
public class ConfigController {
    @Autowired
    private DataSource dataSource;

    @RequestMapping("/datasource")
    public Object datasource() {
        Map<String, Object> datasource = new HashMap<>();
        datasource.put("status", "success");
        datasource.put("message", "datasource获取成功");
        return datasource;
    }
}
