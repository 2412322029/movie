package com.example.movie.service.impl;

import com.example.movie.dao.UserMapper;
import com.example.movie.pojo.Result;
import com.example.movie.pojo.User;
import com.example.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result<User> register(User user) {
        if (user.getUsername() == null | user.getPassword() == null | user.getUsersex() == null
                | user.getUsertel() == null | user.getTruename() == null) {
            return Result.fail("输入为空");
        } else {
            User u=userMapper.selectByName(user.getUsername());
            if (u.getId()!=null){
                return Result.fail("用户名已注册");
            }else {
                userMapper.adduser(user);
                if (user.getId() != null) {
                    return Result.success(user);
                } else {
                    return Result.fail("注册失败");
                }
            }

        }
    }

    @Override
    public Result<User> login(User user) {
        log.info(user + "");
        if (user == null) {
            return Result.fail("空内容，登录失败");
        } else {
            User u = userMapper.checkUser(user);
            if (u != null) {
                return Result.success(u);
            } else {
                return Result.fail("登录失败");
            }

        }

    }

    @Override
    public Result<List<User>> findAllUser() {
        List<User> uList= userMapper.findAll();
        return Result.success("用户信息查询成功",uList);
    }
}
