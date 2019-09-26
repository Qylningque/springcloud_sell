package com.linco.product.service.impl;

import com.linco.product.common.DecreaseStockInput;
import com.linco.product.common.ProductInfoOutput;
import com.linco.product.dataobject.ProductInfo;
import com.linco.product.enums.ProductStatusEnum;
import com.linco.product.enums.ResultEnum;
import com.linco.product.exception.ProductException;
import com.linco.product.repository.ProductInfoRepository;
import com.linco.product.service.ProductService;
import com.linco.product.utils.JsonUtil;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Classname: ProductServiceImpl
 * @description: ProductService实现类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 14:11
 * @Version 1.0
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findAllByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        // 1.减库存
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);
        // 2.转换对象
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e,productInfoOutput);
            log.info("转换后的对象:{}",productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());
        // 3.发送MQ消息到其它服务
        amqpTemplate.convertAndSend("productInfo",JsonUtil.toJson(productInfoOutputList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
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
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
