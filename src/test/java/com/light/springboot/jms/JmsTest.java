package com.light.springboot.jms;

import com.light.springboot.configure.jms.JmsReceiver;
import com.light.springboot.configure.jms.JmsSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @descrption:
 * @author: bubbles
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTest {

    @Autowired
    private JmsSender jmsSender;

    @Autowired
    private JmsReceiver jmsReceiver;

    @Test
    public void testSendByQueue(){
        for (int i = 1; i < 11; i++) {
            jmsSender.sendByQueue1("hello activemq queue " + i);
        }
    }

    @Test
    public void testSendByTopic(){
        for (int i = 1; i < 11; i++) {
            jmsSender.sendByTopic1("hello activemq topic " + i);
        }
    }



}
