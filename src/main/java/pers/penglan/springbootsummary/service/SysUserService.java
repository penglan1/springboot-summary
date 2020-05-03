package pers.penglan.springbootsummary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.penglan.springbootsummary.pojo.SysUser;
import pers.penglan.springbootsummary.tk.mapper.SysUserMapper;

import javax.sql.DataSource;

/**
 * @Author PENGL
 * 2020-04-26
 */
@Service
public class SysUserService {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser getUserById(String id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        return sysUser;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,
            propagation = Propagation.REQUIRED)
    public void saveUser(SysUser user) {
        System.out.println("用户保存中...");
    }
}
