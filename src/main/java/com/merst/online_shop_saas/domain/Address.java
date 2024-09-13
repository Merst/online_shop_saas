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
public class Address {
    private UUID id;
    private UUID customerId;
    private int digits;
    private String city;
    private String country;
    private String stateProvince;
    private String zipcode;
    private String nickname;
}
