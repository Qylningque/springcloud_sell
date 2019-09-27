package com.linco.order.enums;

import lombok.Getter;

/**
 * @Classname: ResultEnum
 * @description: 返回状态枚举类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:12
 * @Version 1.0
 */
@Getter
public enum  ResultEnum {

    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDER_STATUS_ERROR(4,"订单状态不正确"),
    ORDER_DETAIL_NOT_EXIST(5,"订单详情不存在"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
