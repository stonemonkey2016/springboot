package com.light.springboot.mapper;

import com.light.springboot.domain.User;

/**
 * @descrption:
 * @author: bubbles
 */
public interface UserDao {
    public int insert(User user);

    public int deleteById(Integer id);

    public int update(User user);

    public User getById(Integer id);
}

