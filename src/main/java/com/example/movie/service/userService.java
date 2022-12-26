package com.example.movie.service;

import com.example.movie.pojo.User;

public interface userService {
    boolean register(User user);

    User login(User user);
}
