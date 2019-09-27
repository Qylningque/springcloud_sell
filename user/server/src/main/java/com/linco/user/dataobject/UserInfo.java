package com.linco.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Classname: UserInfo
 * @description: 用户对象
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 18:41
 * @Version 1.0
 */
@Data
@Entity
public class UserInfo {
    /**用户id*/
    @Id
    private String id;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**openid*/
    private String openid;
    /**角色*/
    private Integer role;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
}
