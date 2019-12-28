package com.light.springboot;

import com.light.springboot.interceptor.JavaMailComponent;
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
public class MailTest {

    @Autowired
    private JavaMailComponent javaMailComponent;

    @Test
    public void test() {
        this.javaMailComponent.sendMail("13521001196@163.com");
    }
}