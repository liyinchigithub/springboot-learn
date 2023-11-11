    package com.example.lyc.springboot.demo.mapper;

    import com.example.lyc.springboot.demo.entity.User;

    import java.util.List;

    public interface UserMapper {
        List<User> findAllUsers(); // 返回 list对象
        User findUserById(int id);// 返回 类对象
        void insertUser(User user);
        void updateUser(User user);
        void deleteUser(int id);
    }
