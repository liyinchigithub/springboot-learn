package com.example.lyc.springboot.demo.mapper;

import com.example.lyc.springboot.demo.dto.DeleteUserResponseDTO;
import com.example.lyc.springboot.demo.entity.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 定义接口（即数据库访问对象）
 * 层级：接口层
 * 作用：定义接口，供外部调用
 * 通常
 *
 * */
public interface UserMapper {
    List<User> findAllUsers(); // 返回 list对象

    User findUserById(int id);// 返回 类对象

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
    // 分页查询
    List<User> getAllUsers(int offset, int limit, String sortField);
}
