package com.example.lyc.springboot.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserResponseDTO {
    private int id;
    private int updates;

    // getters and setters
}
