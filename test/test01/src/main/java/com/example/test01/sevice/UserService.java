package com.example.test01.sevice;


import com.example.test01.mapper.UserMapper;
import com.example.test01.mapper.UserPreciseMapper;
import com.example.test01.model.User;
import com.example.test01.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserPreciseMapper userPreciseMapper;

    @Autowired
    UserMapper userMapper;

    public List<UserAccount> validateLogin(String username, String phone) {
        List<UserAccount> userPreciseWithUsernameAndPhone = userPreciseMapper.getUserPreciseWithUsernameAndPhone(username, phone);
        return userPreciseWithUsernameAndPhone;
    }

    public User testservice(Integer id) {
        User usertest = userMapper.findUserById(id);
        System.out.println(usertest);
        return usertest;
    }
}