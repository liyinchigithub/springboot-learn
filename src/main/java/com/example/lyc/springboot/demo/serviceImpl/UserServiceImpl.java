package com.example.lyc.springboot.demo.serviceImpl;

import com.example.lyc.springboot.demo.event.MyEvent;
import com.example.lyc.springboot.demo.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lyc.springboot.demo.mapper.UserMapper;
import com.example.lyc.springboot.demo.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService接口的实现类
 * 层级：Service > Mapper > Dao
 * 作用：
 * 通常在这边，通过调用数据对象（UserMapper.java）中的方法，实现对数据库的操作。
 * UserService的实现（例如UserServiceImpl）通常会使用UserMapper来访问数据库，但它也可能包含其他的业务逻辑，例如验证、错误处理、事务管理等
 *
 * */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserMapper userMapper;//
    @Resource
    private ApplicationContext applicationContext;// 使用ApplicationContext来访问Spring容器中的Bean和资源，如数据库连接、消息服务、定时任务等。通过注入ApplicationContext实例，可以方便地在代码中使用这些资源。

    /**
     * 构造函数
     * 通过构造函数，将数据对象（UserMapper interface）注入到UserServiceImpl中
     * */
    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User getUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(User user) {
        userMapper.insertUser(user);
        // 返回新生成的ID
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        int updates = userMapper.updateUser(user);
        // 返回的执行结果  1成功 0
        return updates;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(int id) {
        int updates = userMapper.deleteUser(id);
        // 返回的执行结果 1成功 0
        return updates;
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();// 当调用此方法时，会抛出异常，并回滚事务，不会插入数据
    }


    @Override
    public List<User> getAllUsers(int page, int size, String sortField) {
        log.debug("page" + page + " size" + size + " sortField" + sortField);
        // 检查page和size参数的有效性
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page must be non-negative and size must be positive");
        }

        // 检查sortField参数的有效性
        if (sortField == null || sortField.isEmpty()) {
            sortField = "id";  // 使用一个默认的排序字段
        }

        int offset = page * size;
        return userMapper.getAllUsers(offset, size, sortField);
    }

    /**
     * 发布事件
     * @return
     */
    public User getUser2() {
        // TODO 数据库查询
        User user = new User(1, "liyinchi", "123456", 0);
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }


}