package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Categories;
import com.example.bhxd.entity.Products;
import com.example.bhxd.service.impl.ProductsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsServiceImpl productsService;
    @PostMapping("insert")
    public Response Insertproducts(@RequestBody Products products)
    {
        return productsService.InsertProducts(products);
    }
    @GetMapping("select")
    public Response selectproducts(@RequestParam int id )
    {
        return productsService.selectProducts(id);
    }
    @PutMapping("Permissions")
    public Response Permissionsproducts(@RequestBody Products products )
    {
        return productsService.PermissionsProducts(products);
    }
    @DeleteMapping("/delete")
    public Response deleteproducts(@RequestParam int id )
    {
        return productsService.deleteProducts(id);
    }
    @PutMapping("/updata")
    public Response updataproducts(@RequestBody Products products )
    {
        return productsService.updataProducts(products);
    }
}
