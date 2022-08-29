package com.ring.rabbitmq_consumer.fanout.sortMessage;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.ShortMessage")
public class FanoutSortMessage {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("短信系统收到消息  : " +testMessage.toString());
    }
}
