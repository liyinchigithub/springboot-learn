package com.example.lyc.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LbsInfo {

    private Long id;
    private Long userId;
    private Double latitude;
    private Double longitude;
    private String address;
    // Getters and Setters
}