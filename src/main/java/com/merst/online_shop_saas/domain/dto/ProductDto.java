package com.merst.online_shop_saas.domain.dto;

import java.util.UUID;

import com.merst.online_shop_saas.domain.entities.Category;
import com.merst.online_shop_saas.domain.entities.Supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private UUID id;
    private Supplier supplier;
    private Category category;
    private String name;
    private float price;
    private boolean isAvailable;
    private float saleMultiplier;
    private String description;
    
}
