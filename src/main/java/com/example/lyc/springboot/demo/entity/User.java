package com.example.lyc.springboot.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Schema(name = "User", description = "用户实体类")
public class User {
    @Schema(name = "id", description = "用户id")
    private int id;
    @Schema(name = "userName", description = "用户名")
    private String userName;
    @Schema(name = "password", description = "密码")
    private String password;

    /* 省略get、set和带参构造方法、无参构造函数 */

}
