package com.linco.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Classname: GirlConfig
 * @description: 测试SpringCloud BUS自动刷新配置
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-25 16:28
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties("girl")
@RefreshScope
public class GirlConfig {

    private Integer age;

    private String name;

}
