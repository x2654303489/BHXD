package com.example.bhxd.service.impl;

import com.example.bhxd.Response;
import com.example.bhxd.entity.Orders;
import com.example.bhxd.entity.Payments;
import com.example.bhxd.mapper.PaymentsMapper;
import com.example.bhxd.service.IPaymentsService;
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
public class PaymentsServiceImpl extends ServiceImpl<PaymentsMapper, Payments> implements IPaymentsService {

    public Response insertpayments(Payments payments) {
        if(save(payments))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }

    public Response selectpayments(int id) {
        if (getById(id)!=null){

            return Response.OK( getById(id) ,"查询成功");
        }else return Response.OK(list(),"查询成功");
    }
}
