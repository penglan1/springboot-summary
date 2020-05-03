package pers.penglan.springbootsummary.controller;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.penglan.springbootsummary.service.SysPrivilegeService;

/**
 * @Author PENGL
 * 2020-03-23
 */
@Controller
@RequestMapping(path = "/first")
public class FirstController {
    @Autowired
    private Logger logger;

    @Autowired
   private SysPrivilegeService sysPrivilegeService;

    @RequestMapping(path = "/hello")
    public ModelAndView sayHello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello World, Hello SpringMVC");
        modelAndView.setViewName("/jsp/notification.jsp");
        return modelAndView;
    }

    @RequestMapping(path = "/sysPrivilege")
    public String getSysPrivilegeById(@RequestParam(name = "id") Long id, ModelMap modelMap) {
        return sysPrivilegeService.getSysPrivilegeById(id, modelMap);
    }

    @RequestMapping(path = "/insert")
    public String insertSysPrivilege(ModelMap modelMap) {
        org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger("sbs");
        logger.trace("==============================================");
        String s = sysPrivilegeService.insertSysPrivilege(modelMap);
        logger.trace("==============================================");
        return  s;
    }
    @RequestMapping(path = "/update")
    public String updateSysPrivilege(Long id, ModelMap modelMap) {
        return sysPrivilegeService.updateSysPrivilege(id, modelMap);
    }

    @RequestMapping("/test.h")
    public String staticResources() {
        System.out.println("我这里如果找到了，则不会继续往下找静态资源了");
        return "/test2.html";
    }
}
