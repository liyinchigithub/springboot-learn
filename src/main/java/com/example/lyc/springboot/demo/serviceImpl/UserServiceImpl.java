package com.example.lyc.springboot.demo.serviceImpl;

import com.example.lyc.springboot.demo.dto.DeleteUserResponseDTO;
import com.example.lyc.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lyc.springboot.demo.mapper.UserMapper;
import com.example.lyc.springboot.demo.entity.User;
import java.util.List;

/**
 * UserService接口的实现类
 * 层级：Service > Mapper > Dao
 * 作用：
 * 通常在这边，通过调用数据对象（UserMapper.java）中的方法，实现对数据库的操作。
 * UserService的实现（例如UserServiceImpl）通常会使用UserMapper来访问数据库，但它也可能包含其他的业务逻辑，例如验证、错误处理、事务管理等
 *
 * */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;//

    /**
     * 构造函数
     * 通过构造函数，将数据对象（UserMapper interface）注入到UserServiceImpl中
     * */
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
    public int addUser(User user) {
        userMapper.insertUser(user);
        // 返回新生成的ID
        return user.getId();
    }

    @Override
    public int updateUser(User user) {
        int updates = userMapper.updateUser(user);
        // 返回的执行结果  1成功 0
        return updates;
    }

    @Override
    public int deleteUser(int id) {
        int updates = userMapper.deleteUser(id);
        // 返回的执行结果 1成功 0
        return updates;
    }
}