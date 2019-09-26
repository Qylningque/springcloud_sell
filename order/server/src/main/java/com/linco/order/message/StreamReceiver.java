package com.linco.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Classname: StreamReceiver
 * @description: StreamClient实现类
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-26 14:08
 * @Version 1.0
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /**
     * 接受Controller传过来的对象
     * @param message
     * @return
     */
    @StreamListener(value = StreamClient.INPUT)
    public void processInput(Object message){
        log.info("StreamReceiver(INPUT->OUTPUT2):{}",message);
    }

    @StreamListener(value = StreamClient.OUTPUT)
    @SendTo(StreamClient.OUTPUT2)
    public String processOutput(Object message){
        log.info("StreamReceiver1(OUTPUT):{}",message);
        return "Receiver1已收到";
    }

    @StreamListener(value = StreamClient.INPUT2)
    public void processInput2(String message){
        log.info("StreamReceiver2(INPUT2):{}",message);
    }

    @StreamListener(value = StreamClient.OUTPUT2)
    public void processOutput2(String message){
        log.info("StreamReceiver2(OUTPUT2):{}",message);
    }

}
