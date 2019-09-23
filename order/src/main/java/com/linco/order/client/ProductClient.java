package com.linco.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Classname: ProductClient
 * @description: Feign 调用
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 13:11
 * @Version 1.0
 */
@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/productServer/getMsg")
    String productMsg();

}
