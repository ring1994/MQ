package com.ring.rabbitmq_provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkRabbitmqConfig {
    /**
     * work形式的
     */
    @Bean
    public Queue queueWork() {
        System.out.println("work形式加载了");
        return new Queue("queue_work",true);
    }


    @Bean
    FanoutExchange workExchange() {
        return new FanoutExchange("WorkExchange");
    }

    //绑定  将队列和交换机绑定
    @Bean
    Binding bindingExchangeWorkMessage() {
        return BindingBuilder.bind(queueWork()).to(workExchange());
    }
}
