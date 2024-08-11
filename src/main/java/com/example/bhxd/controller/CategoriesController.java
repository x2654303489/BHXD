package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Categories;
import com.example.bhxd.service.impl.CategoriesServiceImpl;
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
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesServiceImpl categoriesServiceImpl;
    @PostMapping("insert")
    public Response Insertcategories(@RequestBody Categories categories)
    {
        return categoriesServiceImpl.InsertCategories(categories);
    }
    @GetMapping("select")
    public Response selectcategories(@RequestParam int id )
    {
        return categoriesServiceImpl.selectCategories(id);
    }
    @GetMapping("selectpro")
    public Response selectprocategories( )
    {
        return categoriesServiceImpl.selectproCategories();
    }
    @PutMapping("update")
    public Response updatecategories(@RequestBody Categories categories )
    {
        return categoriesServiceImpl.updatecategories(categories);
    }
    @PutMapping("updatestate")
    public Response updatestatecategories(@RequestBody Categories categories )
    {
        return categoriesServiceImpl.updatestatecategories(categories);
    }
    @DeleteMapping("delete")
    public Response deletecategories(@RequestParam int id )
    {
        return categoriesServiceImpl.deletecategories(id);
    }

}
