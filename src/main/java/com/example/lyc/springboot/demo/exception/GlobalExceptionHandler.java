package com.example.lyc.springboot.demo.exception;

import com.example.lyc.springboot.demo.commons.api.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
@ResponseBody   // @ResponseBody注解是为了异常处理完之后给调用方输出一个 json 格式的封装数据。
public class GlobalExceptionHandler {
    // 打印log
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @Description: 处理所有不可知的异常
     * @param ex
     * @return
     */
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
//        // 这里可以记录日志，发送通知等
//        return new ResponseEntity<>("请求参数错误", HttpStatus.BAD_REQUEST);
//    }

    /**
     * @Description 空指针异常
     * @param ex NullPointerException
     * @return
     */
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    public JsonResult handleTypeMismatchException(NullPointerException ex) {
//        log.error("空指针异常，{}", ex.getMessage());
//        return new JsonResult("500", "空指针异常了");
//    }


    /**
     * 系统异常 预期以外异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new JsonResult("500", "系统发生异常，请联系管理员");
    }


}
