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
@TableName("categories")
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CategoryID", type = IdType.AUTO)
    private Integer CategoryID;

    @TableField("CategoryName")
    private String CategoryName;

    @TableField("ParentCategoryID")
    private Integer ParentCategoryID;

    @TableField("CreateTime")
    private LocalDateTime CreateTime;
    @TableField("State")
    private Integer State;

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer CategoryID) {
        this.CategoryID = CategoryID;
    }
    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
    public Integer getParentCategoryID() {
        return ParentCategoryID;
    }

    public void setParentCategoryID(Integer ParentCategoryID) {
        this.ParentCategoryID = ParentCategoryID;
    }
    public LocalDateTime getCreateTime() {
        return CreateTime;
    }

    public void setState(Integer State) {
        this.State = State;
    }
    public Integer getState() {
        return State;
    }

    public void setCreateTime(LocalDateTime CreateTime) {
        this.CreateTime = CreateTime;
    }

    @Override
    public String toString() {
        return "Categories{" +
            "CategoryID=" + CategoryID +
            ", CategoryName=" + CategoryName +
            ", ParentCategoryID=" + ParentCategoryID +
            ", CreateTime=" + CreateTime +
        "}";
    }
}
