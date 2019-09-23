package com.linco.product.service.impl;

import com.linco.product.common.DecreaseStockInput;
import com.linco.product.dataobject.ProductInfo;
import com.linco.product.enums.ProductStatusEnum;
import com.linco.product.enums.ResultEnum;
import com.linco.product.exception.ProductException;
import com.linco.product.repository.ProductInfoRepository;
import com.linco.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput:decreaseStockInputList){
            Optional<ProductInfo> productOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            //1.判断商品是否存在
            if(!productOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.判断库存是否足够
            ProductInfo productInfo = productOptional.get();
            Integer number = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (number<0){
                //库存不足
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //3.将库存信息更新到商品信息中
            productInfo.setProductStock(number);
            productInfoRepository.save(productInfo);
        }
    }
}
