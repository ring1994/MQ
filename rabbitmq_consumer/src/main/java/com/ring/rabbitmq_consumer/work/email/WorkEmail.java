package com.ring.rabbitmq_consumer.work.email;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue_work")
public class WorkEmail {
    @RabbitHandler
    public void process(String message){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("邮件收到消息" + message);
    }
}
