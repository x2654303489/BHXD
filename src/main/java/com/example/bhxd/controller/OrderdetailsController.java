package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Orderdetails;
import com.example.bhxd.entity.Orders;
import com.example.bhxd.service.impl.OrderdetailsServiceImpl;
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
@RequestMapping("/orderdetails")
public class OrderdetailsController {
    @Autowired
    OrderdetailsServiceImpl orderdetailsService;
    @PostMapping("insert")
    public Response Insertorderdetails(@RequestBody Orderdetails orderdetails)
    {
        return orderdetailsService.insertorderdetails(orderdetails);
    }
    @GetMapping("select")
    public Response selectorderdetails(@RequestParam int id )
    {
        return orderdetailsService.selectorderdetails(id);
    }
}
