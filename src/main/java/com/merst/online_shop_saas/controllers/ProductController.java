package com.merst.online_shop_saas.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.merst.online_shop_saas.domain.dto.ProductDto;
import com.merst.online_shop_saas.domain.entities.Product;
import com.merst.online_shop_saas.mappers.Mapper;
import com.merst.online_shop_saas.services.ProductService;

@RestController
public class ProductController {

    private ProductService productService;
    private Mapper<Product, ProductDto> productMapper;

    @PostMapping(path = "/products")
    public ProductDto createProduct(@RequestBody ProductDto product) {
        Product productEntity = productMapper.mapFrom(product);
        Product savedProductEntity = productService.createProduct(productEntity);
        return productMapper.mapTo(savedProductEntity);
    }
    
}
