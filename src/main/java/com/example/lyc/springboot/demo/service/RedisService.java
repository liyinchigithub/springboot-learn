package com.example.lyc.springboot.demo.service;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * set redis: string类型
     *
     * @param key   key
     * @param value value
     */
    public void setString(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    /**
     * get redis: string类型
     *
     * @param key key
     * @return
     */
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
