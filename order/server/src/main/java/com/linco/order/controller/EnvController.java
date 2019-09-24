package com.linco.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: EnvController
 * @description: 测试Config Client
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-24 21:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/env")
public class EnvController {

    @Value("${env}")
    private String dev;

    @GetMapping("/print")
    private String print(){
        return dev;
    }
}
