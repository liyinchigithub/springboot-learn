package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.config.MicroServiceUrl;
import com.example.lyc.springboot.demo.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/v1")
@Schema(name="", description="")
@Tag(name = "JsonController tags")
public class JsonController {
    @Value("${microservice.url.orderUrl}")
    String orderUrl;// orderUrl变量值 就是application.yml的url.orderUrl值
    @Autowired
    private User user;// 注入
    @Autowired
    MicroServiceUrl MicroServiceUrl; // 注入配置类

    @GetMapping("/user")
    @ResponseBody
    @Operation(summary = "获取用户信息", description = "获取用户信息")
    public User getUser() {
        user.setId(1);
        user.setUserName("李银池");
        user.setPassword("123456");
        // 日志输出
        log.info("user:{}", user);
        // 返回
        return user;
    }

    /***
     * @Description: list
     * @Author: liyinchi
     * @Date: 2023/9/18 11:17
     * @return map
     */
    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表", description = "获取用户列表")
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

    /***
     * @Description: map
     * @Author: liyinchi
     * @Date: 2023/9/18 11:17
     * @return map
     */
    @GetMapping("/map")
    @ResponseBody
    @Operation(summary = "获取用户信息", description = "获取用户信息")
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

    /***
     * @Description: 读取application.yml配置文件参数
     * @Author: liyinchi
     * @Date: 2023/9/18 11:17
     * @return map
     */
    @GetMapping("/getYMLConfig")
    @ResponseBody
    @Operation(summary = "获取配置文件参数", description = "获取配置文件参数")
    public Map<String,Object> getYMLConfig() {
        Map<String,Object> orderUrlList = new HashMap();
        orderUrlList.put("microservice url orderUrl",orderUrl);
        log.info("orderUrl:{}", orderUrl);
        return orderUrlList;
    }

    /***
     * @Description: 读取application.yml配置文件参数
     * @Author: liyinchi
     * @Date: 2023/9/18 11:17
     * @return map
     */
    @GetMapping("/getYMLConfigClass")
    @ResponseBody
    @Operation(summary = "获取配置文件参数", description = "获取配置文件参数")
    public Map<String,Object> getYMLConfigClass() {
        Map<String,Object> orderUrlList = new HashMap();
        orderUrlList.put("orderUrl",MicroServiceUrl.getOrderUrl());
        orderUrlList.put("userUrl",MicroServiceUrl.getUserUrl());
        orderUrlList.put("shoppingUrl",MicroServiceUrl.getShoppingUrl());
        log.info("getYMLConfigClass orderUrlMap:{}", orderUrlList);
        return orderUrlList;
    }

    /***
     * @Description: 获取请求体
     * @Date: 20239/18 14:00
     * @param User user
     * @return map
     */
    @PostMapping("/addUser")
    @ResponseBody
    @Operation(summary = "获取请求体", description = "获取请求体")
    public Map<String,Object> getUser(@RequestBody @Parameter User user) { // 获取请求体
        Map<String,Object> map = new HashMap();
        map.put("user",user);
        return map;
    }

}