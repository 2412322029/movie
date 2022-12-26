package com.example.movie.controller;

import com.example.movie.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class userController {
    @Resource
    private com.example.movie.dao.userMapper userMapper;

    @PostMapping("/register")
    public boolean register(@RequestBody User user){
        log.info(""+user);
        return userMapper.adduser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user){
        return userMapper.login(user);
    }
}
