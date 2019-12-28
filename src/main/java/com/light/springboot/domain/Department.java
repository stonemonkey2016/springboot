package com.light.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @descrption:
 * @author: bubbles
 */
@Setter
@Getter
public class Department implements Serializable {

    private static final long serialVersionUID = 3044822437289975056L;

    private Integer id;

    private String name;

    private String descr;
}
