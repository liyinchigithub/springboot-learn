package com.example.lyc.springboot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;

    /* 省略get、set和带参构造方法 */

}
