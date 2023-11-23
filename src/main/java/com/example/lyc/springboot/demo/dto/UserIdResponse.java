package com.example.lyc.springboot.demo.dto;

import lombok.Data;

@Data
public class UserIdResponse {
    private int id;

    public UserIdResponse(int id) {
        this.id = id;
    }

    // getters and setters
}
