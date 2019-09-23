package com.linco.order.controller;

import com.linco.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * 1.通过RestTemplate的第一种调用方式
     * 缺点，url固定写不方便修改和维护
     * @return
     */
    @GetMapping("/getProductMsg1")
    public String getProductMsg1(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8764/productServer/getMsg", String.class);
        log.info("response={}",result);
        return result;
    }

    /**
     * 2.通过RestTemplate的第二种调用方式
     * 利用LoadBalancerClient通过应用名获取url，再使用RestTemplate
     * @return
     */
    @GetMapping("/getProductMsg2")
    public String getProductMsg2(){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/productServer/getMsg");
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}",response);
        return response;
    }

    /**
     * 3.通过RestTemplate的第三种调用方式
     * 利用@LoadBalanced注解，可在restTemplate里使用应用名字
     * @return
     */
/*    @GetMapping("/getProductMsg3")
    public String getProductMsg3() {
        String response = restTemplate.getForObject("http://PRODUCT/productServer/getMsg",String.class);
        log.info("response={}",response);
        return response;
    }*/

    @Autowired
    private ProductClient productClient;

    /**
     * 通过Feign来实现通信
     * 1.pom引入依赖
     * 2.启动类添加@EnableFeignClients注解
     * 3.调用接口添加@FeignClient(name="xxx")指定服务
     * @return
     */
    @GetMapping("/getProductMsg4")
    public String getProductMsg4(){
        String response = productClient.productMsg();
        log.info("response={}",response);
        return response;
    }
}
