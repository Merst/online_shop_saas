package com.merst.online_shop_saas.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.merst.online_shop_saas.domain.dto.ProductDto;
import com.merst.online_shop_saas.domain.entities.Product;
import com.merst.online_shop_saas.mappers.Mapper;

@Component
public class ProductMapperImpl implements Mapper<Product, ProductDto> {

    private ModelMapper modelMapper;

    public ProductMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductDto mapTo(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Product mapFrom(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }    
}
