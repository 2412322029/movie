package com.example.movie.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Info {
    //plan信息
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm",timezone = "GMT+8")
    private Date playtime;
    private BigDecimal price;
    private String seats;
    private Integer status;
    private Integer hall_id;
    private Integer movie_id;
    //movie信息
    private String name;
    private String img;
    private String description;
    private String director;
    private String writer;
    private String actor;
    private String type;
    private String area;
    private String language;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showtime;
    private String length;
    private double grade;
    private String link;
}
