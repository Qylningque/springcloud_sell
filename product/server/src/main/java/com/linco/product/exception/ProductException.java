package com.linco.product.exception;

import com.linco.product.enums.ResultEnum;

/**
 * @Classname: ProductException
 * @description: 封装商品异常信息
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 15:15
 * @Version 1.0
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
