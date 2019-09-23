package com.linco.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: ServerController
 * @description: ServerController 供其它服务调用
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-23 11:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/productServer")
public class ServerController {

    @GetMapping("/getMsg")
    public String msg(){
        return "this is product server msg";
    }
}
