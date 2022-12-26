package com.example.movie.dao;

import com.example.movie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    void adduser(User user);

    User checkUser(User user);

    User selectByName(String username);
}
