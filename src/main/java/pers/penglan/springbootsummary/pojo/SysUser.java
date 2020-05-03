package pers.penglan.springbootsummary.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 使用lombok的@Data注解，生成getter和setter方法
 *
 * @Author PENGL
 * 2020-04-24
 */
@Data
/*使用JPA注解*/
@Table(name = "sys_user")
public class SysUser {
    @Id
    private String id;

    private String userName;

    private String userPassword;

    private String userMail;

    private String userInfo;

    private String headImg;

    private String createTime;
}
