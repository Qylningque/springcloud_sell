package com.linco.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.linco.order.utils.JsonUtil;
import com.linco.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname: ProductInfoReceiver
 * @description: 用于接受商品服务传过来的商品信息消息
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-26 16:01
 * @Version 1.0
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        // message—>ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message,
                new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息:{}","productInfo",productInfoOutputList);
        //储存到Redis中
        for (ProductInfoOutput output : productInfoOutputList){
            stringRedisTemplate.opsForValue()
                    .set(String.format(PRODUCT_STOCK_TEMPLATE,output.getProductId())
                            ,String.valueOf(output.getProductStock()));
        }
    }

}
