package com.example.test01.mapper;

import com.example.test01.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    // 使用注解的方式定义一个简单的查询（可选，只是为了演示）

    User findUserById(Integer id);

    // 或者你可以不在这里使用注解，而是在 XML 文件中定义 SQL
    // List<User> findUsers(); // 这个方法需要在 XML 文件中定义
}