package com.wang.test;

import com.wang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wanglimin
 * @date 2020-05-31 13:55
 *
 * Redis测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    /**
     * 添加键值对
     */
    @Test
    public void test1(){
        this.redisTemplate.opsForValue().set("key","test");
    }
    /**
     * 获取数据
     */
    @Test
    public void test2(){
        String value = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    /**
     * 添加User
     */
    @Test
    public void test3(){
        User user = new User();
        user.setAge(30);
        user.setId(1);
        user.setName("王利民");
        //更换序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("user",user);
    }

    /**
     * 获取User
     */
    @Test
    public void test4(){
        //更换序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    /**
     * 添加User(JSON)
     */
    @Test
    public void test5(){
        User user = new User();
        user.setAge(3);
        user.setId(2);
        user.setName("李四");
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        this.redisTemplate.opsForValue().set("user",user);
    }
    /**
     * 获取User(JSON)
     */
    @Test
    public void test6(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }
}

