package com.light.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @descrption:
 * @author: bubbles
 */
@RestController
public class TestController {

    @RequestMapping("/helloworld")
    public String helloworld(){
        return "helloworld";
    }

    @RequestMapping("/helloworld2")
    public String helloworld2(){
        return "helloworld2";
    }

}
