package com.example.movie;

import com.example.movie.dao.UserMapper;
import com.example.movie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MovieApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        User u=userMapper.checkUser(user);
        System.out.println(u+"");
    }

}
