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

public class Payment {
    private UUID id;
    private UUID orderId;
    private String method;
    private String status;
    private Timestamp createdAt;
    private Timestamp completedAt;
}
