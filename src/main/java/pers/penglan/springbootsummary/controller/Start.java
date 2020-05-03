package pers.penglan.springbootsummary.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author PENGL
 * 2020-04-21
 */
@RestController
@RequestMapping("/start")
public class Start {

    @Autowired
    private Logger logger;

    @RequestMapping("/hello")
    public Object hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("message", "Hello World");
        logger.debug("我访问了/start/hello");
        return map;
    }
}
