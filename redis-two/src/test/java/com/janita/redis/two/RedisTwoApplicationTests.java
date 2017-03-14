package com.janita.redis.two;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Janita on 2017/3/14 0014
 * reids-one
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTwoApplicationTests {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void testRedis(){
        ValueOperations<String,String> operations = template.opsForValue();
        operations.set("two","啊啊啊啊啊");
    }
}
