package com.linco.product.service;

import com.linco.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Classname: ProductService
 * @description: ProductService
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 14:09
 * @Version 1.0
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

}
