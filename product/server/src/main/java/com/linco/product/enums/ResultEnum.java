package com.linco.product.enums;

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

    PRODUCT_NOT_EXIST(1,"商品不存在"),
    PRODUCT_STOCK_ERROR(2,"库存有误"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
