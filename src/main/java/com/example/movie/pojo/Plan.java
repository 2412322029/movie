package com.example.movie.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Plan {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm", timezone = "GMT+8")
    private Date playtime;
    private BigDecimal price;
    private String seats;
    private Integer status;
    private Integer hall_id;
    private Integer movie_id;
}
