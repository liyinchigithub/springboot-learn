package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.dto.UserDTO;
import com.example.lyc.springboot.demo.entity.User;
import com.example.lyc.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User 控制器
 * 层级：控制器->服务层->数据访问层
 * 作用：处理用户相关的请求
 * 在这个例子中，UserController中的每个方法都会将User对象转换为UserDTO对象，然后返回UserDTO对象。
 * convertToDto和convertToEntity方法用于在User和UserDTO之间进行转换。
 * */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return convertToDto(user);
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.addUser(user);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }


    private UserDTO convertToDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    private User convertToEntity(UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}