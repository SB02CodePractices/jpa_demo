package com.sb02.jpa_demo.service;

import java.time.Instant;

public record ProductInfo(
        Long id,
        String name,
        int price,
        String category,
        boolean inStock,
        String description,
        Instant createdAt,
        Instant updatedAt
) {
}
