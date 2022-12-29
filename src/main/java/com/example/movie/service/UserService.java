package com.example.movie.service;

import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;

import java.util.List;

public interface UserService {
    Result<User> register(User user);

    Result<User> login(User user);

    List<User> findUserByPage(Integer pageNum, Integer pageSize);

    Integer findTotals();
}
