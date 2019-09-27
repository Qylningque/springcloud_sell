package com.linco.user.enums;

import lombok.Getter;

/**
 * @Classname: RoleEnum
 * @description: 角色枚举
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 19:26
 * @Version 1.0
 */
@Getter
public enum  RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家"),
    ;

    private Integer code;

    private String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
