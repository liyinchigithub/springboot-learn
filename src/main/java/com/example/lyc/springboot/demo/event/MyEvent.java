package com.example.lyc.springboot.demo.event;

import com.example.lyc.springboot.demo.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * @author liyinchi
 * @date 2023/12/13
 */
@Getter
@Setter
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    // 省去get、set方法
}