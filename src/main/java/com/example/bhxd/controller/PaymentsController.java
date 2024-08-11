package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Orders;
import com.example.bhxd.entity.Payments;
import com.example.bhxd.service.impl.OrdersServiceImpl;
import com.example.bhxd.service.impl.PaymentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    PaymentsServiceImpl paymentsService;
    @PostMapping("insert")
    public Response Insertpayments(@RequestBody Payments payments)
    {
        return paymentsService.insertpayments(payments);
    }
    @GetMapping("select")
    @PreAuthorize("hasRole('admin')")
    public Response selectpayments(@RequestParam int id )
    {
        return paymentsService.selectpayments(id);
    }
}
