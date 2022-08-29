package com.ring.rabbitmq_consumer.fanout.weChat;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.WeChat")
public class FanoutWeChat {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("微信系统收到消息  : " +testMessage.toString());
    }
}
