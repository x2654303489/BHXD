package com.example.bhxd.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.bhxd.Response;
import com.example.bhxd.entity.Orders;
import com.example.bhxd.mapper.OrdersMapper;
import com.example.bhxd.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    public Response insertorders(Orders orders) {
        if(save(orders))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }

    public Response selectorders(int id) {
        if (getById(id)!=null){

            return Response.OK( getById(id) ,"查询成功");
        }else return Response.OK(list(),"查询成功");
    }

    public Response putorders(Orders orders) {
        return Response.OK();
    }
}
