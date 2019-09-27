package com.linco.apigateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @Classname: ZuulConfig
 * @description: 动态路由配置
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-27 11:16
 * @Version 1.0
 */
public class ZuulConfig {

    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}
