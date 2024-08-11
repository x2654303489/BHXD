package com.example.bhxd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@TableName("users")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UsersA  {

    @TableId(value = "UserID", type = IdType.AUTO)
    private Integer userID;

    @TableField("Username")
    private String username;

    @TableField("Password")
    private String password;

    @TableField("Email")
    private String email;

    @TableField("PhoneNumber")
    private String phoneNumber;

    @TableField("RegisterTime")
    private LocalDateTime registerTime;

    @TableField("LastLoginTime")
    private LocalDateTime lastLoginTime;

    @TableField("Status")
    private String status;


}
