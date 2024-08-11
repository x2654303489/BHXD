package com.example.test01.controller;

import com.example.test01.model.User;
import com.example.test01.model.UserAccount;
import com.example.test01.sevice.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/login") // 更改映射路径以增加清晰度

public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User login(@RequestBody UserCredentials userCredentials) {

        User user = userService.testservice(userCredentials.getId());
        return user;

    }
}

// 单独的UserCredentials类（应位于单独的文件中）
@Data
class UserCredentials {
    private Integer id;

}