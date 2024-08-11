package com.example.bhxd.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@TableName("products")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ProductID", type = IdType.AUTO)
    private Integer ProductID;

    @TableField("ProductName")
    private String ProductName;

    @TableField("Description")
    private String Description;

    @TableField("Price")
    private BigDecimal Price;

    @TableField("StockQuantity")
    private Integer StockQuantity;

    @TableField("ImageURL")
    private String ImageURL;

    @TableField("CategoryID")
    private Integer CategoryID;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;

    @TableField("UpdateTime")
    private LocalDateTime UpdateTime;

    @TableField("UserID")
    private Integer UserID;

    @TableField("Status")
    private String Status;

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }
    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal Price) {
        this.Price = Price;
    }
    public Integer getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(Integer StockQuantity) {
        this.StockQuantity = StockQuantity;
    }
    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }
    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer CategoryID) {
        this.CategoryID = CategoryID;
    }
    public LocalDateTime getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(LocalDateTime CreateTime) {
        this.CreateTime = CreateTime;
    }
    public LocalDateTime getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(LocalDateTime UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer UserID) {
        this.UserID = UserID;
    }



    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Products{" +
            "ProductID=" + ProductID +
            ", ProductName=" + ProductName +
            ", Description=" + Description +
            ", Price=" + Price +
            ", StockQuantity=" + StockQuantity +
            ", ImageURL=" + ImageURL +
            ", CategoryID=" + CategoryID +
            ", CreateTime=" + CreateTime +
            ", UpdateTime=" + UpdateTime +
        "}";
    }
}
