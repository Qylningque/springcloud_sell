package com.linco.order.exception;

import com.linco.order.enums.ResultEnum;

/**
 * @Classname: OrderException
 * @description: 封装订单异常信息
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:10
 * @Version 1.0
 */
public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
