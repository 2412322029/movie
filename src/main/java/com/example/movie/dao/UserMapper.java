package com.example.movie.dao;

import com.example.movie.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User,Integer>{
    void adduser(User user);

    User checkUser(User user);

    User selectByName(String username);
}
