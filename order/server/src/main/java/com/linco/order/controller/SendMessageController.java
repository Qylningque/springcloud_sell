package com.linco.order.controller;

import com.linco.order.dto.OrderDTO;
import com.linco.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Classname: SendMessageController
 * @description: 发送消息，SpringCloudStream
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-26 14:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/sendStreamMessage")
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/send")
    public void send(){
        String message = "now:" + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    @GetMapping("/sendObject")
    public void sendObject(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1edqwa");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }

}
