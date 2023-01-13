package com.mahnoor.springmvc.controller.mappers;

import com.mahnoor.springmvc.domain.DTOs.ProductDTO;
import com.mahnoor.springmvc.domain.Product;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface ProductMapper {


    ProductDTO productDtoToProduct(Product product);
    Product productToProductDto(ProductDTO productDTO);
}
