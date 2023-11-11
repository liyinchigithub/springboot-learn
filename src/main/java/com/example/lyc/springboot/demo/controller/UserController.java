package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.entity.User;
import com.example.lyc.springboot.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id) {
        return userMapper.findUserById(id);
    }

    @PostMapping("/")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PutMapping("/")
    public void updateUser(@RequestBody User user) {
        userMapper.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userMapper.deleteUser(id);
    }
}
