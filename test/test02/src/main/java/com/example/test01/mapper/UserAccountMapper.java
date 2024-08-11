package com.example.test01.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test01.daomain.UserAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserAccountMapper extends BaseMapper<UserAccount> {
    // 如果有额外的Mapper方法，可以在这里定义
    default UserAccount selectByUsername(String username) {
        QueryWrapper<UserAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username); // 直接使用列名
        return selectOne(queryWrapper); // 调用 BaseMapper 中的 selectOne 方法
    }
}
