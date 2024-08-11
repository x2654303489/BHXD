package com.example.bhxd.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDTO {
    private Integer ProductID;
    private String ProductName;
    private String Description;
    private BigDecimal Price;
    private Integer StockQuantity;
    private String ImageURL;
    private String Category;
    private String User;
    private String Status;
    private LocalDateTime UpdateTime;

}
