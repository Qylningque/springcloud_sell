package com.linco.user.enums;

import lombok.Getter;

/**
 * @Classname: ResultEnum
 * @description: 返回信息枚举类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 15:16
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    LOGIN_FAIL(1,"登录失败"),
    ROLE_ERROR(2,"角色权限有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
