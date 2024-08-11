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
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OrderID", type = IdType.AUTO)
    private Integer OrderID;

    @TableField("UserID")
    private Integer UserID;

    @TableField("OrderStatus")
    private String OrderStatus;

    @TableField("TotalAmount")
    private BigDecimal TotalAmount;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;

    @TableField("PaymentTime")
    private LocalDateTime PaymentTime;

    @TableField("CompletionTime")
    private LocalDateTime CompletionTime;

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }
    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }
    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal TotalAmount) {
        this.TotalAmount = TotalAmount;
    }
    public LocalDateTime getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(LocalDateTime CreateTime) {
        this.CreateTime = CreateTime;
    }
    public LocalDateTime getPaymentTime() {
        return PaymentTime;
    }

    public void setPaymentTime(LocalDateTime PaymentTime) {
        this.PaymentTime = PaymentTime;
    }
    public LocalDateTime getCompletionTime() {
        return CompletionTime;
    }

    public void setCompletionTime(LocalDateTime CompletionTime) {
        this.CompletionTime = CompletionTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "OrderID=" + OrderID +
            ", UserID=" + UserID +
            ", OrderStatus=" + OrderStatus +
            ", TotalAmount=" + TotalAmount +
            ", CreateTime=" + CreateTime +
            ", PaymentTime=" + PaymentTime +
            ", CompletionTime=" + CompletionTime +
        "}";
    }
}
