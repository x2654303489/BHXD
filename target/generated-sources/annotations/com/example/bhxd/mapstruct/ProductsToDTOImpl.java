package com.example.bhxd.mapstruct;

import com.example.bhxd.dto.ProductsDTO;
import com.example.bhxd.entity.Products;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T19:17:52+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ProductsToDTOImpl implements ProductsToDTO {

    @Override
    public ProductsDTO productToProductDto(Products product) {
        if ( product == null ) {
            return null;
        }

        ProductsDTO productsDTO = new ProductsDTO();

        return productsDTO;
    }
}
