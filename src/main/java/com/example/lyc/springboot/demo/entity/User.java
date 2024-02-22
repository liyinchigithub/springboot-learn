package com.example.lyc.springboot.demo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/***
 * User 实体类
 * 层级：模型层(Model)
 * 作用：
 * 属性：
 */

@Data   //  自动生成getter/setter方法
@AllArgsConstructor //   自动生成全参构造器
@NoArgsConstructor //  自动生成无参构造器
@Component //  注册到spring容器
@Schema(name = "User", description = "用户实体类") // swagger 标注
public class User {
    @Schema(name = "id", description = "用户id")
    private int id;
    @Schema(name = "userName", description = "用户名")
    private String userName;
    @Schema(name = "password", description = "密码")
    private String password;
    private int updates;

    /* 省略get、set 和 带参构造方法、无参构造函数 */

}
