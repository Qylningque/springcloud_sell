package com.linco.product.client;

import com.linco.product.common.DecreaseStockInput;
import com.linco.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Classname: ProductClient
 * @description: Feign 调用
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 13:11
 * @Version 1.0
 */
@FeignClient(name="product")
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
