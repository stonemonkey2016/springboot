package com.light.springboot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @descrption:
 * @author: bubbles
 */
@Entity
@Setter
@Getter
public class Role implements Serializable {
    private static final long serialVersionUID = -6128955755371603106L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private String descr;
}
