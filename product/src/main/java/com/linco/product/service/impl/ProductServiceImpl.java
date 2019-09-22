package com.linco.product.service.impl;

import com.linco.product.dataobject.ProductInfo;
import com.linco.product.enums.ProductStatusEnum;
import com.linco.product.repository.ProductInfoRepository;
import com.linco.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname: ProductServiceImpl
 * @description: ProductService实现类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 14:11
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findAllByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
