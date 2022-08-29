package com.ring.rabbitmq_provider.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitmqConfig {

    /**
     * fanout形式的
     *  创建三个队列 ：fanout.ShortMessage   fanout.Email  fanout.WeChat
     *  将三个队列都绑定在交换机 fanoutExchange 上
     *  因为是扇型交换机, 路由键无需配置,配置也不起作用
     */



    @Bean
    public Queue queueShortMessage() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        System.out.println("发布订阅加载了");
        return new Queue("fanout.ShortMessage",true);
    }

    @Bean
    public Queue queueEmail() {
        return new Queue("fanout.Email",true);
    }

    @Bean
    public Queue queueWeChat() {
        return new Queue("fanout.WeChat",true);
    }

    //Fanout交换机 起名：fanoutExchange

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    //绑定  将队列和交换机绑定
    @Bean
    Binding bindingExchangeShortMessage() {
        return BindingBuilder.bind(queueShortMessage()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeEmail() {
        return BindingBuilder.bind(queueEmail()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeWeChat() {
        return BindingBuilder.bind(queueWeChat()).to(fanoutExchange());
    }

}
