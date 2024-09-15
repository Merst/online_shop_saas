package com.merst.online_shop_saas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    
    private String name;
    private float price;
    private boolean isAvailable;
    private float saleMultiplier;
    private String description;
}
