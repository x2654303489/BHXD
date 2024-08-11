package com.example.test01.rervice;

import com.example.test01.common.Result;

public interface UserAccountServie {
    Result UserAccountSelect(String username, String userpassword, String sql_usernam, String sql_userpassword);
}
