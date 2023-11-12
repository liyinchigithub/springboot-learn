package com.example.lyc.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lyc.springboot.demo.entity.User;
import com.example.lyc.springboot.demo.mapper.UserMapper;

import java.util.List;

/**
 *  用户服务
 *  即在Service层中，调用数据对象UserMapper中的方法，实现对数据库的操作
 *  **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }

    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}