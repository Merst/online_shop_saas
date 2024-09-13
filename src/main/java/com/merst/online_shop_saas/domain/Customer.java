package com.merst.online_shop_saas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String locale;
    private Timestamp createdAt;
    private Timestamp lastLogin;
    private boolean emailValidated;
}