package com.example.movie.service;

import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;

public interface UserService {
    Result<User> register(User user);

    Result<User> login(User user);
}
