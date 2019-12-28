package com.light.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.Map;

/**
 * @descrption:
 * @author: bubbles
 */
@RestController
@RequestMapping("/freemark")
public class FreemarkController {

    @RequestMapping("/hello")
    public ModelAndView hello(Map<String, Object> map) {
        map.put("msg", "freemark RestController");
        return new ModelAndView("hello");
    }
}
