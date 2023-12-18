package com.example.lyc.springboot.demo.controller;

import com.example.lyc.springboot.demo.producer.MsgProducer;
import jakarta.annotation.Resource;
import jakarta.jms.Destination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ActiveMQ controller
 * @author liyinchi
 */
@RestController
@RequestMapping("/activemq")
public class ActiveMqController {
    private static final Logger logger = LoggerFactory.getLogger(ActiveMqController.class);
    @Resource
    private MsgProducer producer;
    @Resource
    private Destination queue;

    @GetMapping("/send/queue")
    public String sendQueueMessage() {
        logger.info("===开始发送点对点消息===");
        producer.sendMessage(queue, "Queue: hello activemq!");
        return "success";
    }
}