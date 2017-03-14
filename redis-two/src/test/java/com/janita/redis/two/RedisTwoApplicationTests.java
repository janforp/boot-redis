package com.janita.redis.two;

import com.janita.redis.two.bean.Shop;
import com.janita.redis.two.bean.User;
import com.janita.redis.two.util.RedisUtilsTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by Janita on 2017/3/14 0014
 * reids-one
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTwoApplicationTests {

    @Resource(name = "redisTemplate")
    private RedisUtilsTemplate redisUtilsTemplate;

    @Test
    public void testRedis(){
        User user = new User();
        user.setId(1);
        user.setName("Jan");
        user.setAge(25);
      redisUtilsTemplate.setex("user",user,30000);
      user = redisUtilsTemplate.getObj("user");
      print(user);
    }

    @Test
    public void testShop(){
        Shop shop = new Shop();
        shop.setId(UUID.randomUUID().toString());
        shop.setName("全家");
        shop.setAddress("萧山");
        shop.setRemark("日本连锁店");

        redisUtilsTemplate.setex("shop",shop,5);

        print(redisUtilsTemplate.getObj("shop"));
    }

    @Test
    public void testString(){
        redisUtilsTemplate.set("string","字符串");
        print(redisUtilsTemplate.get("string"));
    }

    public void print(Object param){
        System.out.println("*******"+param);
    }
}