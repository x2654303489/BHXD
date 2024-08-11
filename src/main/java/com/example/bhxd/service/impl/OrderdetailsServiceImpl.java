package com.example.bhxd.service.impl;

import com.example.bhxd.Response;
import com.example.bhxd.entity.Orderdetails;
import com.example.bhxd.mapper.OrderdetailsMapper;
import com.example.bhxd.service.IOrderdetailsService;
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
public class OrderdetailsServiceImpl extends ServiceImpl<OrderdetailsMapper, Orderdetails> implements IOrderdetailsService {

    public Response insertorderdetails(Orderdetails orderdetails) {
        if(save(orderdetails))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }

    public Response selectorderdetails(int id) {

        if (getById(id)!=null){

            return Response.OK( getById(id) ,"查询成功");
        }else return Response.OK(list(),"查询成功");
    }
}
