package com.linco.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @Classname: CrosConfig
 * @description: 跨域配置
 * C-Cross   O-Origin  R-Resource  S-Sharing 跨域资源共享
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-28 18:14
 * @Version 1.0
 */
@Component
public class CrosConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        //是否支持cookie跨域
        config.setAllowCredentials(true);
        //设置放置的原始域 如：http://www.a.com
        config.setAllowedOrigins(Arrays.asList("*"));
        //设置允许的头
        config.setAllowedHeaders(Arrays.asList("*"));
        //设置放置的方法如 GET POST PUT
        config.setAllowedMethods(Arrays.asList("*"));
        //设置缓存时间，在缓存时间内相同的跨域请求直接按照配置不再检查
        config.setMaxAge(300L);
        //将路径和配置注册到source上去
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }

}
