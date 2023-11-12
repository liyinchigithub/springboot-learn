package com.example.lyc.springboot.demo.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String password;
    // 自动生成getter和setter方法
}