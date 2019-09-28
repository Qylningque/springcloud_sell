package com.linco.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Classname: HystrixController
 * @description: HystrixController
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-28 22:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/hystrix")
@DefaultProperties(defaultFallback = "defaultFallBack")
public class HystrixController {
    /**
     * 方法调用错误则调用容错方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.patchForObject("http://localhost:8764/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);
    }

    public String fallback(){
        return "Hystrix 容错触发";
    }

    public String defaultFallBack(){
        return "Hystrix 默认容错触发";
    }

}
