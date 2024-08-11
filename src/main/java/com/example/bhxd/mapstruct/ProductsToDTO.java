package com.example.bhxd.mapstruct;




import com.example.bhxd.dto.ProductsDTO;
import com.example.bhxd.entity.Products;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel =   "Spring" )
public interface ProductsToDTO {


    ProductsDTO productToProductDto(Products product);
}
