package com.linco.product.service;

import com.linco.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @Classname: ProductCategoryService
 * @description: 类目Service
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 14:41
 * @Version 1.0
 */
public interface ProductCategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
