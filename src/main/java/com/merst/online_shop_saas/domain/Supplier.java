package com.merst.online_shop_saas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    private UUID id;
    private String name;
}