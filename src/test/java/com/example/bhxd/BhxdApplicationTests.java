package com.example.bhxd;



import com.example.bhxd.entity.Users;
import com.example.bhxd.entity.UsersA;
import com.example.bhxd.servlet.LoginUser;
import com.example.bhxd.utils.BCryptutils;


import com.example.bhxd.utils.CacheClientUtills;
import com.example.bhxd.utils.RedisCache;
import com.example.bhxd.utils.TokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BhxdApplicationTests {
    @Autowired
    RedisCache redisCache;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    CacheClientUtills cacheClientUtills;
    @Test
    void contextLoads() {

        String encode = BCryptutils.BCryjm("123456");
        System.out.println(encode);
        System.out.println(BCryptutils.matchesPassword("123456","$2a$10$IQPZjEDGmV.Ct2pfM5M1duPerIZcnyOOeD7ihUtIgDR/EZQQbXXbe"));
    }
    @Test
    void jwttest(){
        String compact = Jwts.builder().setSubject("123456").compact();
        System.out.println(compact);
    }
    @Test
    void jwttest1(){

            Map<String, String> map = new HashMap<>();
            String tokenByKey = TokenUtil.genAccessToken("1");
            map.put("encoding", tokenByKey);
        System.out.println(map);
        }
    @Test
    void jwttest2(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiMSIsImp0aSI6ImRiNDQyOWMxLTIwYWEtNDUzOC1iNmYyLWE0N2VjM2EwOGY0NyIsImV4cCI6MTcyMTM0NDgzMSwiaWF0IjoxNzIxMTI4ODMxLCJzdWIiOiJQZXJpcGhlcmFscyIsImlzcyI6IlRpYW0ifQ.HIfjrcsQGfWp3toQ39oDLaDn-dCrU-b69yhFpNiB7JY";
        Claims claims = TokenUtil.parsePayload(token);
//        String name = (String)claims.get("name");
        System.out.println(claims);
    }
    @Test
    void jwttest3(){
//
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
////            Users user = mapper.readValue(jsonString, Users.class);
////            System.out.println(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @Test
    void jwttest4() {
        LoginUser loginUser = getLoginUserFromCache("token:1");
        if (loginUser != null) {
            System.out.println(loginUser);
        } else {
            System.out.println("Redis 中没有找到对应的 LoginUser 对象");
        }
    }

    // 封装从 Redis 中获取 LoginUser 对象的逻辑
    private LoginUser getLoginUserFromCache(String key) {
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj instanceof String) {
            // 假设数据是以 JSON 字符串的形式存储的
            String jsonString = (String) obj;
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.readValue(jsonString, LoginUser.class);
            } catch (IOException e) {
                e.printStackTrace();
                // 可以选择记录日志或抛出异常
                return null;
            }
        } else if (obj instanceof byte[]) {
            // 假设数据是以 Java 序列化的字节数组形式存储的（不推荐）
            byte[] serializedData = (byte[]) obj;
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedData))) {
                return (LoginUser) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                // 可以选择记录日志或抛出异常
                return null;
            }
        }
        // 如果对象不是预期的字符串或字节数组，则可能表示 Redis 中没有存储该键或存储了无效的数据
        return null;
    }
    @Test
    void jwttest5(){
        Users cacheObject = cacheClientUtills.get("token:1", Users.class);

//        LoginUser loginUser = new LoginUser(new Users());
        System.out.println(cacheObject);
    }
    @Test
    void jwttest16(){
        test a =  new test("张三");
        redisCache.setCacheObject("test:1",a);
        test b = cacheClientUtills.get("test:1", test.class);

        System.out.println(b);
    }
}
