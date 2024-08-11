package com.example.test01.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor//无参
@AllArgsConstructor//满参
@TableName("user_account")
public class UserAccount {
    private Integer id;
    private String username;
    private String userpassword;
    private Integer permissions;
}
