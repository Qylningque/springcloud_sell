package com.linco.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Classname: OrderForm
 * @description: 提交信息表单
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:07
 * @Version 1.0
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;


}
