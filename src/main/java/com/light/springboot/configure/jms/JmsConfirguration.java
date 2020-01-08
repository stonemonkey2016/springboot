package com.light.springboot.configure.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * @descrption:
 * @author: bubbles
 */
@Configuration
public class JmsConfirguration {

    public static final String QUEDU_NAME1 = "activemq_queue1";

    public static final String TOPIC_NAME1 = "activemq_topic1";

    @Bean
    public Queue queue1(){
        return new ActiveMQQueue(QUEDU_NAME1);
    }

    @Bean
    public Topic topic1(){
        return new ActiveMQTopic(TOPIC_NAME1);
    }

    /**
     * JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory, PubSubDomain = true
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(connectionFactory);
        return topicListenerContainer;
    }

    /**
     *  上面 topicListenerContainer 设置了 PubSubDomain = true, 使用队列时需要重新设置 PubSubDomain = false
     */
    @Bean
    public JmsListenerContainerFactory<?> queueListenerContainer(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory queueListenerContainer = new DefaultJmsListenerContainerFactory();
        queueListenerContainer.setPubSubDomain(false);
        queueListenerContainer.setConnectionFactory(connectionFactory);
        return queueListenerContainer;
    }


}
