package com.light.springboot.configure.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @descrption:消费者1
 * @author: bubbles
 */
@Component
public class JmsReceiver {

    @JmsListener(destination = JmsConfirguration.QUEDU_NAME1,containerFactory = "queueListenerContainer")
    public void receiveByQueue1(String message){
        System.out.println("消费者1接收队列消息:" + message);
    }

    @JmsListener(destination = JmsConfirguration.TOPIC_NAME1,containerFactory = "topicListenerContainer")
    public void receiveByTopic1(String message){
        System.out.println("消费者1接收主题消息:" + message);
    }

}
