package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.commons.api.JsonResult;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.example.lyc.springboot.demo.exception.BusinessErrorException;
import com.example.lyc.springboot.demo.exception.BusinessMsgEnum;

@Slf4j
@RestController
@RequestMapping("/exception")
@Schema(name="exception test", description="exception")
@Tag(name = "JsonController tags")
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/nullPointException")
    public JsonResult test(@RequestBody String userName,
                           @RequestBody String password) {
        // 日志
        log.info("name：{}", userName);
        log.info("pass：{}", password);
        throw new NullPointerException("空指针异常");
        //return new JsonResult();
    }

    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }

}






