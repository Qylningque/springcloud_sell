package com.linco.order.enums;

import lombok.Getter;

/**
 * @Classname: OrderStatusEnums
 * @description: 订单状态枚举工具类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 10:28
 * @Version 1.0
 */
@Getter
public enum OrderStatusEnums {

    NEW(0,"新下单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
