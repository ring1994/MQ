package com.ring.rabbitmq_consumer.fanout.email;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "fanout.Email")
public class FanoutEmail {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("邮件系统收到消息  : " +testMessage.toString());
    }
}
