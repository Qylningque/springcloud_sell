package com.linco.order.enums;

import lombok.Getter;

/**
 * @Classname: PayStatusEnums
 * @description: 支付状态枚举类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 10:31
 * @Version 1.0
 */
@Getter
public enum  PayStatusEnums {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
