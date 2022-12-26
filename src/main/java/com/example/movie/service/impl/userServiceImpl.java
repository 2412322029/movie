package com.example.movie.service.impl;

import com.example.movie.pojo.User;
import com.example.movie.service.userService;

import javax.annotation.Resource;

public class userServiceImpl implements userService {

    @Resource
    private com.example.movie.dao.userMapper userMapper;

    @Override
    public boolean register(User user) {
        return userMapper.adduser(user);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
