package com.light.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @descrption:
 * @author: bubbles
 */
@RestController
public class TestController {

    /**
     * @Desc:
     * @Param: []
     * @Return: java.lang.String
     * @Author: bubbles
     * @Date: 2019/12/25 10:25
     **/
    @RequestMapping("/helloworld")
    public String helloworld() {
        return "你好helloworld你好";
    }

    /**
     * @Desc:
     * @Param: []
     * @Return: java.lang.String
     * @Author: bubbles
     * @Date: 2019/12/27 14:54
     **/
    @RequestMapping("/helloworld2")
    public String helloworld2() {
        return "helloworld2";
    }


}
