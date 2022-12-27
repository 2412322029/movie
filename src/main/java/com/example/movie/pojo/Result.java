package com.example.movie.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Result<T> {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> createResult(boolean success, Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(success);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        return createResult(true, 200, "请求成功", data);
    }

    public static <T> Result<T> success(String msg, T data) {
        return createResult(true, 200, msg, data);
    }

    public static <T> Result<T> fail(String msg) {
        return createResult(false,400,msg,null);
    }

    public static <T> Result<T> fail(Integer code,String msg) {
        return createResult(false,code,msg,null);
    }

    public static <T> Result<T> fail(Integer code,String msg,T data) {
        return createResult(false,code,msg,data);
    }
}
