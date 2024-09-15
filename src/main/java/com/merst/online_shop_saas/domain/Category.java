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
@Table(name = "category")
public class Category {
    @Id
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    private String name;
    private String description;
}
