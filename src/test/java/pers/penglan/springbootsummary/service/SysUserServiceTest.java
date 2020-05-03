package pers.penglan.springbootsummary.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.penglan.springbootsummary.SpringbootSummaryApplication;
import pers.penglan.springbootsummary.pojo.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootSummaryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserServiceTest {
    @Autowired
    private SysUserService sysUserService;

    @Test
    public void getUserById() {
        SysUser sysUser = sysUserService.getUserById("1");
        System.out.println(sysUser);
    }

    @Test
    public void saveUser() {

    }
}