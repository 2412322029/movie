package com.example.movie.service;

import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;

import java.util.List;

public interface MovieService {
    Result<Movie> addMovie(Movie movie);

    Result<List<Movie>> findAll();
}
