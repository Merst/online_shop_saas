package com.merst.online_shop_saas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private UUID id;
    private UUID supplierId;
    private UUID categoryId;
    private String name;
    private float price;
    private boolean isAvailable;
    private float sale_multiplier;
    private String description;
}
