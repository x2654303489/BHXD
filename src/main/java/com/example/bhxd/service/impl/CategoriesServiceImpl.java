package com.example.bhxd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bhxd.Response;
import com.example.bhxd.entity.Categories;
import com.example.bhxd.mapper.CategoriesMapper;
import com.example.bhxd.service.ICategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements ICategoriesService {

    public Response InsertCategories(Categories categories) {
        if(save(categories))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }

    public Response selectCategories(int id) {

        if (getById(id)!=null){

            return Response.OK( getById(id) ,"查询成功");
        }else return Response.OK(list(),"查询成功");
    }

    public Response updatecategories(Categories categories) {
        Categories categories1 = new Categories();
        categories1.setCategoryID(categories.getCategoryID());
        categories1.setCategoryName(categories.getCategoryName());
        if (updateById(categories1)){
            return Response.OK("修改成功");
        }return Response.NO("修改失败");
    }

    public Response deletecategories(int id) {

        if (removeById(id)){
            return Response.OK("删除成功");
        }return Response.NO("删除失败");
    }

    public Response updatestatecategories(Categories categories) {
        Categories categories1 = new Categories();
        categories1.setCategoryID(categories.getCategoryID());
        categories1.setState(categories.getState());
        if (updateById(categories1)){
            return Response.OK("修改成功");
        }return Response.NO("修改失败");
    }

    public Response selectproCategories() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("State",1);
        return Response.OK(list(queryWrapper),"查询成功");
    }
}
