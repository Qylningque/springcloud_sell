package com.linco.order.message;

import com.linco.order.utils.JsonUtil;
import com.linco.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        // message—>ProductInfoOutput
        ProductInfoOutput productInfoOutput = (ProductInfoOutput)JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列【{}】接收到消息:{}","productInfo",productInfoOutput);
        //储存到Redis中
    }

}
