package com.example.movie.service;

import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;

import java.util.List;

public interface UserService {
    Result<User> register(User user);

    Result<User> login(User user);

    Result<List<User>> findAllUser();
}
