package com.light.springboot.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @descrption:
 * @author: bubbles
 */
@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private String password;
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;
}
