package com.example.bhxd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@TableName("users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "UserID", type = IdType.AUTO)
    private Integer UserID;

    @TableField("Username")
    private String Username;

    @TableField("Password")
    private String Password;

    @TableField("Email")
    private String Email;

    @TableField("PhoneNumber")
    private String PhoneNumber;

    @TableField("RegisterTime")
    private LocalDateTime RegisterTime;

    @TableField("LastLoginTime")
    private LocalDateTime LastLoginTime;

    @TableField("Status")
    private String Status;

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    public LocalDateTime getRegisterTime() {
        return RegisterTime;
    }

    public void setRegisterTime(LocalDateTime RegisterTime) {
        this.RegisterTime = RegisterTime;
    }
    public LocalDateTime getLastLoginTime() {
        return LastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime LastLoginTime) {
        this.LastLoginTime = LastLoginTime;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Users{" +
            "UserID=" + UserID +
            ", Username=" + Username +
            ", Password=" + Password +
            ", Email=" + Email +
            ", PhoneNumber=" + PhoneNumber +
            ", RegisterTime=" + RegisterTime +
            ", LastLoginTime=" + LastLoginTime +
            ", Status=" + Status +
        "}";
    }


}
