package com.linco.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname: MqReceiver
 * @description: 接受MQ消息
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-26 12:37
 * @Version 1.0
 */
@Component
@Slf4j
public class MqReceiver {

    // 1. 手动创建队列@RabbitListener(queues = "myQueue")
    @RabbitListener(queues = "myQueue")
    public void process(String message){
        log.info("myQueue={}" + message);
    }

    // 2. 自动创建队列@RabbitListener(queuesToDeclare = @Queue("autoQueue"))
    @RabbitListener(queuesToDeclare = @Queue("autoQueue"))
    public void process2(String message){
        log.info("autoQueue={}" + message);
    }

    /**
     * 3. 自动创建 Exchange和Queue绑定
     * @RabbitListener(bindings = @QueueBinding(
     *             value = @Queue("bindQueue"),
     *             exchange = @Exchange("bindExchange")
     *     ))
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("bindQueue"),
            exchange = @Exchange("bindExchange")
    ))
    public void process3(String message){
        log.info("bindQueue={}" + message);
    }

    /**
     * 练习：水果供应商 接受消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void fruitProcess(String message){
        log.info("fruitQueue={}" + message);
    }
    /**
     * 练习：数码供应商 接受消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerQueue"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void processComputer(String message){
        log.info("computerQueue={}" + message);
    }
}
