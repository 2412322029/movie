package com.example.movie.service;

import com.example.movie.pojo.Hall;
import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;

import java.util.List;

public interface MovieService {
    Result<Movie> addMovie(Movie movie);

    List<Movie> findByPage(Integer pageNum, Integer pageSize);

    Integer findTotals();

    List<Movie> findAllMovie();

    List<Hall> findUsableHall();

    Movie findOne(Integer mid);
}
