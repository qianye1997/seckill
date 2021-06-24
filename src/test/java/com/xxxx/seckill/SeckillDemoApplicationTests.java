package com.xxxx.seckill;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SeckillDemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
//    @Autowired
//    private RedisScript<Boolean> redisScript;
    @Test
    public void textLock() {
//        ValueOperations valueOperations=redisTemplate.opsForValue();
//        String value= UUID.randomUUID().toString();
//        Boolean isLock=valueOperations.setIfAbsent("k1",value, 10,TimeUnit.SECONDS);
//        if(isLock){
//            valueOperations.set("name","xxxx");
//            String name=(String)valueOperations.get("name");
//            System.out.println("name="+name);
//            System.out.println(valueOperations.get("k1"));
//            Boolean result=(Boolean) redisTemplate.execute(redisScript, Collections.singletonList("k1"),value);
//            System.out.println(result);
//        }else{
//            System.out.println("有线程在使用，请稍后");
//        }
    }

}
