package com.example.movie.dao;

import com.example.movie.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper {
    boolean adduser(User user);

    User login(User user);
}
