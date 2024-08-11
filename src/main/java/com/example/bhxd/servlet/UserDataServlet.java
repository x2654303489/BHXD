package com.example.bhxd.servlet;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bhxd.entity.Users;
import com.example.bhxd.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDataServlet implements UserDetailsService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Username",username);
        Users users = usersMapper.selectOne(queryWrapper);
        if (users == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<String> list = new ArrayList<>(Arrays.asList("admin","user"));
        return new LoginUser(users,list);


    }
}
