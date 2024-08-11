package com.example.bhxd.service.impl;

import com.example.bhxd.Response;
import com.example.bhxd.dto.ProductsDTO;
import com.example.bhxd.entity.Categories;
import com.example.bhxd.entity.Products;
import com.example.bhxd.entity.Users;
import com.example.bhxd.mapper.CategoriesMapper;
import com.example.bhxd.mapper.ProductsMapper;
import com.example.bhxd.mapper.UsersMapper;
import com.example.bhxd.mapstruct.ProductsToDTO;
import com.example.bhxd.service.IProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bhxd.utils.CacheClientUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements IProductsService {
//    private final ProductsToDTO productsToDTO;
//
//    // 使用构造器注入Mapper
//    @Autowired
//    public ProductsServiceImpl(ProductsToDTO productsToDTO) {
//        this.productsToDTO = productsToDTO;
//    }
     @Autowired
    ProductsToDTO productsToDTO;
    @Autowired
    private CategoriesMapper categoriesMapper;
    @Autowired
    private UsersMapper usersMapper;
    public Response selectProducts(int id) {
        if (id==0){
            List<Products> productslist = list();
            // 转换productslist中的每个Products对象到ProductsDTO，并设置categoryName
            List<ProductsDTO> productsDTOList = productslist.stream()
                    .map(product -> {
                        ProductsDTO productsDTO = productsToDTO.productToProductDto(product);
                        // 设置categoryName
                        String categoryName = categoriesMapper.selectById(product.getCategoryID()).getCategoryName();
                        String userName = usersMapper.selectById(product.getUserID()).getUsername();
                        productsDTO.setUser(userName);
                        productsDTO.setCategory(categoryName);

                        return productsDTO;
                    })
                    .collect(Collectors.toList());

            return Response.OK(productsDTOList, "查询成功");
        }
        else{
            Products products = getById(id);
            ProductsDTO productsDTO = productsToDTO.productToProductDto(products);
            String categoryName = categoriesMapper.selectById(products.getCategoryID()).getCategoryName();
            String userName = usersMapper.selectById(products.getUserID()).getUsername();
            productsDTO.setUser(userName);
            productsDTO.setCategory(categoryName);
            return Response.OK( productsDTO ,"查询成功");
        }
    }

    public Response InsertProducts(Products products) {
        if(save(products))return Response.OK("插入成功");
        else return Response.NO("插入失败");
    }

    public Response PermissionsProducts(Products products) {
        Products products1 = new Products();
        products1.setProductID(products.getProductID());
        products1.setStockQuantity(products.getStockQuantity());
        updateById(products1);
        return Response.OK("修改成功");
    }

    public Response deleteProducts(int id) {
        if(removeById(id))return Response.OK("删除成功");
        else return Response.NO("删除失败");
    }

    public Response updataProducts(Products products) {
        if (updateById(products)){
            return Response.OK("修改成功");
        }else return Response.NO("修改失败");
    }
}
