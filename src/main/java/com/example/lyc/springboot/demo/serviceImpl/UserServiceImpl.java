package com.example.lyc.springboot.demo.serviceImpl;

import com.example.lyc.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lyc.springboot.demo.mapper.UserMapper;
import com.example.lyc.springboot.demo.entity.User;
import java.util.List;

/**
 * 业务逻辑层（Service）
 * 在这边，通过调用数据对象（UserMapper.java）中的方法，实现对数据库的操作。
 * UserService的实现（UserServiceImpl）通常会使用UserMapper来访问数据库，但它也可能包含其他的业务逻辑，例如验证、错误处理、事务管理等
 *
 * */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}