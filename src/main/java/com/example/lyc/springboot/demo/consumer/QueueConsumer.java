package com.example.lyc.springboot.demo.consumer;

import com.example.lyc.springboot.demo.config.ActiveMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 消息消费者
 * @author liyinchi
 */
@Slf4j
@Service
public class QueueConsumer {

    /**
     * 接收点对点消息
     * @param msg
     */
    @JmsListener(destination = ActiveMqConfig.QUEUE_NAME)//
    public void receiveQueueMsg(String msg) {
        log.info("消费者 收到的消息为：" + msg);
    }
}
