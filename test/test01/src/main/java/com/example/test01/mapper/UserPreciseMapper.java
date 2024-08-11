package com.example.test01.mapper;


import com.example.test01.model.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPreciseMapper {
    // 使用 XML 映射文件中的查询
    List<UserAccount> getUserPreciseWithUsernameAndPhone(@Param("username") String username, @Param("phone") String phone);

    List<UserAccount> testx(@Param("username") String username, @Param("phone") String phone);
}
