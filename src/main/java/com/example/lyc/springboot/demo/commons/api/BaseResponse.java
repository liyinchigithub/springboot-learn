package com.example.lyc.springboot.demo.commons.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author tiltwind
 * @Description 基础响应
 * 用于统一返回格式
 */
@Data  // Lombok注解，自动生成getter、setter、equals、hashCode和toString方法
@Component  // Spring注解，将此类标记为Spring容器管理的Bean
public class BaseResponse<T> {
    public static final int CODE_SUCCESS = 0;  // 成功的状态码
    private int code;  // 响应的状态码
    private String message;  // 响应的消息

    @JsonInclude(JsonInclude.Include.NON_NULL)  // Jackson注解，序列化JSON时忽略null值
    private T data;  // 响应的数据

    public BaseResponse() {  // 默认构造函数，初始化状态码和消息为成功
        this.code = 0;
        this.message = "success";
    }

    public BaseResponse(int code, String message) {  // 构造函数，初始化状态码和消息
        this.code = code;
        this.message = message;
    }

    public BaseResponse(T data) {  // 构造函数，初始化状态码、消息和数据为成功
        this.code = CODE_SUCCESS;
        this.message = "success";
        this.data = data;
    }

    public static BaseResponse<String> success() {  // 静态方法，返回一个成功的响应，没有数据
        return new BaseResponse<>("");
    }

    public static <T> BaseResponse<T> success(T data) {  // 静态方法，返回一个成功的响应，带有数据
        return new BaseResponse<>(data);
    }

    public BaseResponse(int code, String message, T data) {  // 构造函数，初始化状态码、消息和数据
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse<?> error(String msg) {  // 静态方法，返回一个错误的响应，状态码为1，没有数据
        return new BaseResponse<>(1, msg);
    }

    public static BaseResponse<?> error(int code, String msg) {  // 静态方法，返回一个错误的响应，状态码和消息可自定义，没有数据
        return new BaseResponse<>(code, msg);
    }
}