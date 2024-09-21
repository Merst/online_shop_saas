package com.merst.online_shop_saas.services.impl;

import org.springframework.stereotype.Service;

import com.merst.online_shop_saas.domain.entities.Product;
import com.merst.online_shop_saas.repositories.ProductRepository;
import com.merst.online_shop_saas.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
