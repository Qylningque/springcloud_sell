package com.linco.product.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Classname: ProductStatusEnum
 * @description: 商品状态枚举类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 14:13
 * @Version 1.0
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
