package com.linco.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Classname: ProductInfoOutput
 * @description: 商品返回参数
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 13:11
 * @Version 1.0
 */
@Data
public class ProductInfoOutput {

    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;
}
