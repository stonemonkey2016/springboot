package com.light.springboot.controller;

import com.light.springboot.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @descrption:
 * @author: bubbles
 */
@Api(value = "/user", tags = { "测试接口" })
@RestController
@RequestMapping("/swagger2")
public class Swagger2Controller {

    @ApiOperation("获取用户信息")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "string", paramType = "query")
    @GetMapping("/test/{name}")
    public User test(@PathVariable("name") String name) {
        User user = new User();

        user.setId(1);
        user.setUsername(name);
        user.setPassword("jack123");
        user.setBirthday(new Date());

        return user;
    }
}
