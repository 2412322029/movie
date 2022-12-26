package com.example.movie.service;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;

public interface HallService {
    Result<Hall> addHall(Hall hall);
}
