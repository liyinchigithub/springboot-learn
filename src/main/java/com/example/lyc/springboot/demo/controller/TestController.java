package com.example.lyc.springboot.demo.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.lyc.springboot.demo.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyinchi
 * @date 2023/12/14
 * */
@Slf4j
@RestController
@RequestMapping("/v1/test")
public class TestController {
        @RequestMapping("/interceptor")
        public String test() {
            return "hello";
    }

        @Resource
        private RedisService redisService;

        @GetMapping("/testRedis")
        public boolean testRedis() {
            log.info("testRedis");
            //
            return redisService.testRedisConnection();
        }
}


