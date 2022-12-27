package com.example.movie.controller;

import com.example.movie.pojo.Movie;
import com.example.movie.pojo.Result;
import com.example.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
@Slf4j
public class MovieController {
    @Resource
    private MovieService movieService;

    @RequestMapping("/addMovie")
    public Result<Movie> addHall(@RequestBody Movie movie){
        return movieService.addMovie(movie);

    }
    @RequestMapping("/findAll")
    public Result<List<Movie>> findAll(){
        return movieService.findAll();

    }
}
