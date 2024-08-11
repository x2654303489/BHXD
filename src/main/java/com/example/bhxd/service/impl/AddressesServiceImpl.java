package com.example.bhxd.service.impl;

import com.example.bhxd.Response;
import com.example.bhxd.entity.Addresses;
import com.example.bhxd.mapper.AddressesMapper;
import com.example.bhxd.service.IAddressesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AddressesServiceImpl extends ServiceImpl<AddressesMapper, Addresses> implements IAddressesService {


    public Response insertAddressesController(Addresses addresses) {
        if(save(addresses))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }
    public Response selectAddressesController(int id) {
        if (getById(id)!=null){

            return Response.OK( getById(id) ,"查询成功");
        }else return Response.OK(list(),"查询成功");
    }
}
