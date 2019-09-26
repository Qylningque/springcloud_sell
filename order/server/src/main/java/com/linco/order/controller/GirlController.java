package com.linco.order.controller;

import com.linco.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: GirlController
 * @description: 测试SpringCloud BUS自动刷新配置
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-25 16:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/print")
    public String print(){
        return "name:" + girlConfig.getName() + ",age: " + girlConfig.getAge();
    }

}
