package com.ring.rabbitmq_provider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FanoutController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("sendFanoutMessage")
    public String sendFanoutMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "用户已经下单";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String,String> messageMap = new HashMap<>();
        messageMap.put("messageId",messageId);
        messageMap.put("messageData",messageData);
        messageMap.put("createTime",createTime);

        rabbitTemplate.convertAndSend("fanoutExchange",null,messageMap);
        return "ok";
    }
}
