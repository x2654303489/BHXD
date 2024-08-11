package com.example.test01;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.example.test01.daomain.UserAccount;
import com.example.test01.mapper.UserAccountMapper;
//import com.example.test01.rervice.UserAccountServie;
//import com.example.test01.rervice.impl.UserAccountImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class Test01ApplicationTests {
    @Autowired
    UserAccountMapper userAccountMapper;

    public UserAccount selectByColumn(Function<UserAccount, ?> columnGetter, Object columnValue) {
        LambdaQueryWrapper<UserAccount> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq((SFunction<UserAccount, ?>) columnGetter, columnValue); // 使用 Lambda 表达式指定列
        return userAccountMapper.selectOne(lambdaQueryWrapper);
    }

    @Test
    void contextLoads() {
        System.out.println("userAccountImpl.selectById(1) = " + userAccountMapper.selectById(1));
        UserAccount result = selectByColumn(UserAccount::getYourColumnName, "yourValue");
    }

}
