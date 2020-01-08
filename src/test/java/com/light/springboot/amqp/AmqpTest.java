package com.light.springboot.amqp;

import com.light.springboot.configure.amqp.AmqpSender;
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
public class AmqpTest {

    @Autowired
    private AmqpSender amqpSender;

    @Test
    public void testSimpleSend(){
        for (int i = 1; i < 6; i++) {
            amqpSender.simpleSend("test simpleSend " + i);
        }
    }

    @Test
    public void testPsSend() {
        for (int i = 1; i < 6; i++) {
            amqpSender.psSend("test psSend " + i);
        }
    }

    @Test
    public void testRoutingSend() {
        for (int i = 1; i < 6; i++) {
            amqpSender.routingSend("order", "test routingSend " + i);
        }
    }

    @Test
    public void testTopicSend() {
        for (int i = 1; i < 6; i++) {
            amqpSender.topicSend("user.add", "test topicSend " + i);
        }
    }

}
