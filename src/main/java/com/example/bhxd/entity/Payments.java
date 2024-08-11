package com.example.bhxd.entity;

import java.math.BigDecimal;

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
@TableName("payments")
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PaymentID", type = IdType.AUTO)
    private Integer PaymentID;

    @TableField("OrderID")
    private Integer OrderID;

    @TableField("PaymentAmount")
    private BigDecimal PaymentAmount;

    @TableField("PaymentStatus")
    private String PaymentStatus;

    @TableField("PaymentTime")
    private LocalDateTime PaymentTime;

    @TableField("PaymentMethod")
    private String PaymentMethod;

    public Integer getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(Integer PaymentID) {
        this.PaymentID = PaymentID;
    }
    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }
    public BigDecimal getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(BigDecimal PaymentAmount) {
        this.PaymentAmount = PaymentAmount;
    }
    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }
    public LocalDateTime getPaymentTime() {
        return PaymentTime;
    }

    public void setPaymentTime(LocalDateTime PaymentTime) {
        this.PaymentTime = PaymentTime;
    }
    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    @Override
    public String toString() {
        return "Payments{" +
            "PaymentID=" + PaymentID +
            ", OrderID=" + OrderID +
            ", PaymentAmount=" + PaymentAmount +
            ", PaymentStatus=" + PaymentStatus +
            ", PaymentTime=" + PaymentTime +
            ", PaymentMethod=" + PaymentMethod +
        "}";
    }
}
