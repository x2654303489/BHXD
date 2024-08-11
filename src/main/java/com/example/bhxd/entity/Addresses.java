package com.example.bhxd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@TableName("addresses")
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "AddressID", type = IdType.AUTO)
    private Integer AddressID;

    @TableField("UserID")
    private Integer UserID;

    @TableField("RecipientName")
    private String RecipientName;

    @TableField("PhoneNumber")
    private String PhoneNumber;

    @TableField("Province")
    private String Province;

    @TableField("City")
    private String City;

    @TableField("DetailedAddress")
    private String DetailedAddress;

    @TableField("IsDefault")
    private Boolean IsDefault;

    public Integer getAddressID() {
        return AddressID;
    }

    public void setAddressID(Integer AddressID) {
        this.AddressID = AddressID;
    }
    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }
    public String getRecipientName() {
        return RecipientName;
    }

    public void setRecipientName(String RecipientName) {
        this.RecipientName = RecipientName;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    public String getProvince() {
        return Province;
    }

    public void setProvince(String Province) {
        this.Province = Province;
    }
    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }
    public String getDetailedAddress() {
        return DetailedAddress;
    }

    public void setDetailedAddress(String DetailedAddress) {
        this.DetailedAddress = DetailedAddress;
    }
    public Boolean getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(Boolean IsDefault) {
        this.IsDefault = IsDefault;
    }

    @Override
    public String toString() {
        return "Addresses{" +
            "AddressID=" + AddressID +
            ", UserID=" + UserID +
            ", RecipientName=" + RecipientName +
            ", PhoneNumber=" + PhoneNumber +
            ", Province=" + Province +
            ", City=" + City +
            ", DetailedAddress=" + DetailedAddress +
            ", IsDefault=" + IsDefault +
        "}";
    }
}
