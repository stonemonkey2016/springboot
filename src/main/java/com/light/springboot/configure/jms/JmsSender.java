package com.light.springboot.configure.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @descrption:生产者1
 * @author: bubbles
 */
@Component
public class JmsSender {

    @Autowired
    private Queue queue1;

    @Autowired
    private Topic topic1;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    public void sendByQueue1(String message){
        jmsMessagingTemplate.convertAndSend(queue1, message);
    }

    public void sendByTopic1(String message){
        jmsMessagingTemplate.convertAndSend(topic1, message);
    }

}
