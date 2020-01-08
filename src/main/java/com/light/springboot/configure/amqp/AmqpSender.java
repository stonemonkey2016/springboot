package com.light.springboot.configure.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @descrption:生产者1
 * @author: bubbles
 */
@Component
public class AmqpSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * @Desc:   简单模式发送
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:04
     **/
    public void simpleSend(String message){
        amqpTemplate.convertAndSend(AmqpConfiguration.SIMPLE_QUEUE, message);
    }

    /**
     * @Desc:   发布/订阅模式发送
     * @Param:  [message]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:07
     **/
    public void psSend(String message){
        amqpTemplate.convertAndSend(AmqpConfiguration.FANOUT_EXCHANGE, "", message);
    }

    /**
     * @Desc:   路由模式发送
     * @Param:  [message, routingKey]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:07
     **/
    public void routingSend(String routingKey,String message){
        amqpTemplate.convertAndSend(AmqpConfiguration.DIRECT_EXCHANGE, routingKey, message);
    }

    /**
     * @Desc:   主题模式发送
     * @Param:  [message, routingKey]
     * @Return: void
     * @Author: bubbles
     * @Date:   2020/1/8 14:06
     **/
    public void topicSend(String routingKey,String message){
        amqpTemplate.convertAndSend(AmqpConfiguration.TOPIC_EXCHANGE, routingKey, message);
    }





}

















