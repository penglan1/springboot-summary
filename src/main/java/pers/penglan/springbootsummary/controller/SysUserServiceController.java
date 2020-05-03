package pers.penglan.springbootsummary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.penglan.springbootsummary.pojo.SysUser;
import pers.penglan.springbootsummary.service.SysUserService;

/**
 * @Author PENGL
 * 2020-04-26
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserServiceController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/get")
    public Object getById(String id) {
        SysUser sysUser = sysUserService.getUserById(id == null ? "1" : id);
        return sysUser;
    }
}
