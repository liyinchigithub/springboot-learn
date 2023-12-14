package com.example.lyc.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyinchi
 * @date 2023/12/14
 * */
@Slf4j
@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Controller
    @RequestMapping("/interceptor")
    public class InterceptorController {
        @RequestMapping("/test")
        public String test() {
            return "hello";
        }
    }
}
