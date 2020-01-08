package com.light.springboot.configure.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @descrption:消费者2
 * @author: bubbles
 */
@Component
public class AmqpReceiver2 {

    /**
     * @Desc:   简单模式接收
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:29
     **/
    @RabbitListener(queues = AmqpConfiguration.SIMPLE_QUEUE)
    public void simpleReceive(String message){
        System.out.println("消费者2-->"+ "接收消息:" + message);
    }

    /**
     * @Desc:   发布/订阅模式接收1
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:31
     **/
    @RabbitListener(queues = AmqpConfiguration.PS_QUEUE_1)
    public void psReceive1(String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.PS_QUEUE_1 + "接收消息:" + message);
    }
    /**
     * @Desc:   发布/订阅模式接收2
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:31
     **/
    @RabbitListener(queues = AmqpConfiguration.PS_QUEUE_2)
    public void psReceive2(String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.PS_QUEUE_2 + "接收消息:" + message);
    }

    /**
     * @Desc:   路由模式接收1
     * @Param:  [message, routingKey]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:36
     **/
    @RabbitListener(queues = AmqpConfiguration.ROUTING_QUEUE_1)
    public void routingReceive1(String routingKey,String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.ROUTING_QUEUE_1 + "接收消息:" + message + "--> routingKey" + routingKey);
    }

    /**
     * @Desc:   路由模式接收2
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:36
     **/
    @RabbitListener(queues = AmqpConfiguration.ROUTING_QUEUE_2)
    public void routingReceive2(String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.ROUTING_QUEUE_2 + "接收消息:" + message);
    }

    /** 
     * @Desc:   主题模式接收1
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:37
     **/
    @RabbitListener(queues = AmqpConfiguration.TOPIC_QUEUE_1)
    public void topicReceive1(String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.TOPIC_QUEUE_1 + "接收消息:" + message);
    }

    /**
     * @Desc:   主题模式接收2
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:37
     **/
    @RabbitListener(queues = AmqpConfiguration.TOPIC_QUEUE_2)
    public void topicReceive2(String message){
        System.out.println("消费者2-->"+ AmqpConfiguration.TOPIC_QUEUE_2 + "接收消息:" + message);
    }

}
