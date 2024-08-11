package com.example.test01.servet;

import com.example.test01.mapper.UserAccountMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@ControllerAdvice
public class UserLogin {

    UserAccountMapper userAccountMapper;

    @PostMapping("/user")
    public String postData(@RequestBody UserCredentials userCredentials) {
        // 在这里处理接收到的数据
        System.out.println("Received data: " + userCredentials.getUsername() + ", " + userCredentials.getUserpassword());

        // 返回一个响应
        return "Received data: " + userCredentials.getUsername() + ", " + userCredentials.getUserpassword();
    }

    @Data
    static class UserCredentials {
        private String username;
        private String userpassword;
    }

    @GetMapping("/user")
    public String getData(String username, String userpassword) {
        // 在这里处理接收到的数据
        System.out.println("Received data: " + username + userpassword);

        // 返回一个响应
        return username + "Received data: " + userpassword;
    }
}

