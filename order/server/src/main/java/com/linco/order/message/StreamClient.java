package com.linco.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Classname: StreamClient
 * @description: SpringCloud Stream 接口
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-26 14:05
 * @Version 1.0
 */
public interface StreamClient {

    String INPUT = "streamInput";

    String OUTPUT = "streamOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

    String INPUT2 = "streamInput2";

    String OUTPUT2 = "streamOutput2";

    @Input(StreamClient.INPUT2)
    SubscribableChannel input2();

    @Output(StreamClient.OUTPUT2)
    MessageChannel output2();
}
