package com.linco.order.dto;

import lombok.Data;

/**
 * @Classname: CartDTO
 * @description: 购物车对象
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 15:12
 * @Version 1.0
 */
@Data
public class CartDTO {
    /** 商品ID */
    private String productId;
    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
