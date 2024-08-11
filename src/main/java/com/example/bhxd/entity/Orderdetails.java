package com.example.bhxd.entity;

import java.math.BigDecimal;

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
@TableName("orderdetails")
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DetailID", type = IdType.AUTO)
    private Integer DetailID;

    @TableField("OrderID")
    private Integer OrderID;

    @TableField("ProductID")
    private Integer ProductID;

    @TableField("Quantity")
    private Integer Quantity;

    @TableField("UnitPrice")
    private BigDecimal UnitPrice;

    public Integer getDetailID() {
        return DetailID;
    }

    public void setDetailID(Integer DetailID) {
        this.DetailID = DetailID;
    }
    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }
    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }
    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }
    public BigDecimal getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(BigDecimal UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
            "DetailID=" + DetailID +
            ", OrderID=" + OrderID +
            ", ProductID=" + ProductID +
            ", Quantity=" + Quantity +
            ", UnitPrice=" + UnitPrice +
        "}";
    }
}
