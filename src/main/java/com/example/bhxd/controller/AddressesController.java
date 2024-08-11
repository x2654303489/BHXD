package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Addresses;
import com.example.bhxd.entity.Categories;
import com.example.bhxd.service.impl.AddressesServiceImpl;
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
@RequestMapping("/addresses")
public class AddressesController {
    @Autowired
    AddressesServiceImpl addressesController;
    @PostMapping("insert")
    public Response InsertaddressesController(@RequestBody Addresses addresses)
    {
        return addressesController.insertAddressesController(addresses);
    }
    @GetMapping("select")
    public Response selectaddressesController(@RequestParam int id )
    {
        return addressesController.selectAddressesController(id);
    }
}
