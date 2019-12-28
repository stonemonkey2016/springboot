package com.light.springboot.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @descrption:
 * @author: bubbles
 */
@Setter
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = -3828971137324613005L;
    private Integer id;
    private String username;
    private String password;
    @JSONField(format="yyyy-MM-dd")
    private Date birthday;
}
