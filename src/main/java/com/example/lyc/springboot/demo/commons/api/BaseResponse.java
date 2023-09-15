package com.example.lyc.springboot.demo.commons.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tiltwind
 * @Description 基础响应
 * 用于统一返回格式
 */
@Getter
@Setter
public class BaseResponse<T> {

    public static final int CODE_SUCCESS = 0;

    private int code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(T data) {
        this.code = CODE_SUCCESS;
        this.message = "success";
        this.data = data;
    }

        public static BaseResponse<String> success() {
        return new BaseResponse<>("");
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(data);
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse<?> error(String msg) {
        return new BaseResponse<>(1, msg);
    }

    public static BaseResponse<?> error(int code, String msg) {
        return new BaseResponse<>(code, msg);
    }
}
