package com.linco.order.message;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqReceiverTest {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Test
    public void send() throws  Exception{
        amqpTemplate.convertAndSend("myQueue","now={}" + new Date());
    }

    @Test
    public void bindSend() throws  Exception{
        amqpTemplate.convertAndSend("myOrder","computer","now={}" + new Date());
    }

}