package com.light.springboot.interceptor;

import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @descrption:
 * @author: bubbles
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /** 
     * @Desc:   处理 Exception 类型的异常
     * @Param:  [e]
     * @Return: java.util.Map<java.lang.String,java.lang.Object>
     * @Author: bubbles
     * @Date:   2019/12/28 0:40
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> defaultExceptionHandler(Exception e) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}
