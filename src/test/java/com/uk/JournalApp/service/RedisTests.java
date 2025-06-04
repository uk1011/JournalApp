package com.uk.JournalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;



    @Test
    void testSendMail(){
        redisTemplate.opsForValue().set("email","ujkotadiya1011@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
        System.out.println(email);
    }
}
