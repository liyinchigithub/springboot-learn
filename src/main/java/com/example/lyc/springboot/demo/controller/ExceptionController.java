package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.commons.api.JsonResult;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/exception")
@Schema(name="exception test", description="exception")
@Tag(name = "JsonController tags")
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult test(@RequestParam("userName") String userName,
                           @RequestParam("password") String password) {
        // 日志
        log.info("name：{}", userName);
        log.info("pass：{}", password);
        return new JsonResult();
    }

}
