package com.ring.rabbitmq_provider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkController {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法


    @GetMapping("/sendWorkMessage")
    public String sendWorkMessage() {

        for(int i = 0;i < 10; i++) {
            String message = "收到消息：" + i;
            rabbitTemplate.convertAndSend("WorkExchange", null, message);

            System.out.println("发送成功:"+i);
        }
        return "消息发送成功！";
    }
}
