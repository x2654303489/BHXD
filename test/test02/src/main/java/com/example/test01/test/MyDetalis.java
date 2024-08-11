package com.example.test01.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.test01.daomain.UserAccount;

import java.util.List;

public class MyDetalis {
    public List<UserAccount> getListById(String businessId) {
        LambdaQueryWrapper<UserAccount> wrapper = new LambdaQueryWrapper();
        // 商家图片，未删除，可用状态
        LambdaQueryWrapper<UserAccount> eq = wrapper.eq(UserAccount::getUsername, businessId);


        List<UserAccount> list = this.list(wrapper);
        return list;
    }

    private List<UserAccount> list(LambdaQueryWrapper<UserAccount> wrapper) {
    }

}
