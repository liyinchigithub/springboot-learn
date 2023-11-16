package com.example.lyc.springboot.demo.service;

import com.example.lyc.springboot.demo.entity.User;

import java.util.List;

/**
 * 服务接口，定义了业务方法
 * UserService是一个服务接口，它的方法代表了你的应用程序中的业务操作
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
