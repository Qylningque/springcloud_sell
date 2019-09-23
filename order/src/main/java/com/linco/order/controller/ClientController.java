package com.linco.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: ClientController
 * @description: 调用其它服务API
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 12:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/orderClient")
@Slf4j
public class ClientController {

    /**
     * 1.通过RestTemplate的第一种调用方式
     * @return
     */
    @GetMapping("/getProductMsg1")
    public String getProductMsg1(){
        return null;
    }

}
