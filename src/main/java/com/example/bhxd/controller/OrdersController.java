package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Addresses;
import com.example.bhxd.entity.Orders;
import com.example.bhxd.service.impl.AddressesServiceImpl;
import com.example.bhxd.service.impl.OrdersServiceImpl;
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
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersServiceImpl ordersService;
    @PostMapping("insert")
    public Response InsertOrders(@RequestBody  Orders  orders)
    {
        return ordersService.insertorders(orders);
    }
    @GetMapping("select")
    public Response selectOrders(@RequestParam int id )
    {
        return ordersService.selectorders(id);
    }
    @PutMapping("update")
    public Response putOrders(@RequestBody Orders orders )
    {
        return ordersService.putorders(orders);
    }
}
