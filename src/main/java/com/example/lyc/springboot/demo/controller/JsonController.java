package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/v1")
public class JsonController {
    @Autowired
    private User user;
    @RequestMapping("/user")
    public User getUser() {
        user.setId(1);
        user.setUserName("李银池");
        user.setPassword("123456");
        // 日志输出
        log.info("user:{}", user);
        // 返回
        return user;
    }

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "李银池", "123456");
        User user2 = new User(2, "王哈哈", "123456");
        userList.add(user1);
        userList.add(user2);
        // 日志输出
        log.info("userList:{}", userList);
        // 返回数据
        return userList;
    }

    @RequestMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1, "李银池", "123456");
        map.put("作者信息", user);
        map.put("github", "https://github.com/liyinchigithub");
        map.put("CSDN地址", "https://blog.csdn.net/u013302168");
        map.put("粉丝数量", 252);
        // 日志输出
        log.info("map:{}", map);
        // 返回
        return map;
    }
}