package com.example.movie.dao;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class MovieMapperTest {
    @Resource
    private static MovieMapper mapper;

    public static void main(String[] args) {
        System.out.println(mapper.findAll());
    }
}