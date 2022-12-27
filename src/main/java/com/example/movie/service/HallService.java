package com.example.movie.service;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Result;

import java.util.List;

public interface HallService {
    Result<Hall> addHall(Hall hall);

    Result<List<Hall>> findAll();
}
