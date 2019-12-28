package com.light.springboot.controller;

import com.light.springboot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @descrption:
 * @author: bubbles
 */
@Controller
@RequestMapping("/fastjson")
public class FastJsonController {

    @RequestMapping("/test")
    @ResponseBody
    @CrossOrigin(origins = {"http://localhost:8088"})
    //@CrossOrigin(origins = "http://localhost:8088")
    public User test(){
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());

        // 模拟异常
        int i = 1/0;

        return user;
    }

}
