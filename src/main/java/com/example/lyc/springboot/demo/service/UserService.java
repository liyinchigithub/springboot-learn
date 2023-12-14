package com.example.lyc.springboot.demo.service;

import com.example.lyc.springboot.demo.entity.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * UserService 接口
 * 层级：业务逻辑层（Service）、接口层（API）
 * 作用：定义了业务方法，它的方法代表了你的应用程序中的业务操作
 *
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    @Transactional
    void insertUser(User user);

    List<User> getAllUsers(int page, int size, String sortField);
}
