package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.commons.api.BaseResponse;
import com.example.lyc.springboot.demo.dto.DeleteUserRequestDTO;
import com.example.lyc.springboot.demo.dto.UserDTO;
import com.example.lyc.springboot.demo.entity.User;
import com.example.lyc.springboot.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public BaseResponse<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream().map(this::convertToDto).collect(Collectors.toList());
        log.info("=======getAllUsers: " + userDTOs);
        return BaseResponse.success(userDTOs);
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public BaseResponse<UserDTO> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        log.info("=======getUserById user:{}", user);
        return BaseResponse.success(convertToDto(user));
    }

    /**
     * ?id=1&name=zhangsan
     * 表单
     * */
    @RequestMapping(value = "/getUserByIdParam", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public BaseResponse<UserDTO> getUserByIdParam(@RequestParam("id") int id) {
        User user = userService.getUserById(id);
        log.info("=======getUserByIdParam user:{}", user);
        return BaseResponse.success(convertToDto(user));
    }

    /**
     * 新增用户
     * */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public BaseResponse<String> addUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.addUser(user);
        log.info("=======addUser:{}", user);
        return BaseResponse.success();
    }


    /**
     * 更改用户
     * */
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT,produces = "application/json; charset=UTF-8")
    public BaseResponse<String> updateUser(@RequestBody UserDTO userDto) {
        User user = convertToEntity(userDto);
        userService.updateUser(user);
        log.info("=======updateUser:{}", user);
        return BaseResponse.success();
    }

    /**
     * 删除用户-参数在request body 中
     * */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    public BaseResponse<String>  deleteUser(@RequestBody DeleteUserRequestDTO request) {
        userService.deleteUser(request.getId());
        log.info("=======deleteUser:{}", request);
        return BaseResponse.success();
    }

    /**
     * 删除用户-参数在URI中
     * */
    @RequestMapping(value = "/deleteUserPath/{id}", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    public BaseResponse<String> deleteUserPath(@PathVariable int id) { // id在URI中
        userService.deleteUser(id);
        log.info("=======deleteUserPath:{}", id);
        return BaseResponse.success();
    }

    /**
     * 删除用户-参数在URI中 ?id=
     * */
    @RequestMapping(value = "/deleteUserParam", method = RequestMethod.DELETE,produces = "application/json; charset=UTF-8")
    public BaseResponse<String> deleteUserParam(@RequestParam("id") int id) { // id在URI中
        userService.deleteUser(id);
        log.info("=======deleteUserParam:{}", id);
        return BaseResponse.success();
    }

    /**
     *
     * */
    private UserDTO convertToDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        log.info("=======convertToDto:{}", userDto);
        return userDto;
    }


    /**
     *
     * */
    private User convertToEntity(UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        log.info("=======convertToEntity:{}", user);
        return user;
    }
}