package com.example.test01.rervice.impl;

import com.example.test01.common.Result;
import com.example.test01.daomain.UserAccount;
import com.example.test01.rervice.UserAccountServie;
import com.example.test01.utils.BCryptutils;

public class UserAccountImpl implements UserAccountServie {
    UserAccount userAccount = new UserAccount();

    @Override
    public Result UserAccountSelect(String username, String userpassword, String sql_usernam, String sql_userpassword) {
        userpassword = BCryptutils.BCryjm(userpassword);
        if ((!sql_usernam.equals(username)) || (!sql_userpassword.equals(userpassword)))
            return new Result(-1, "用户名或密码错误");
        else
            return new Result(1L, userAccount);
    }
}
