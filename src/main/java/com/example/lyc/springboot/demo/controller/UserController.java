package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.dto.DeleteUserRequestDTO;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return convertToDto(user);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.addUser(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.updateUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody DeleteUserRequestDTO request) {
        userService.deleteUser(request.getId());
    }

    @RequestMapping(value = "/deleteUserPath/{id}", method = RequestMethod.DELETE)
    public void deleteUserPath(@PathVariable int id) { // id在URI中
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