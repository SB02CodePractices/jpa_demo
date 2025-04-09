package com.sb02.jpa_demo.service;

public record RegisterProductCommand(
        String name,
        int price,
        String category,
        boolean inStock,
        String description
) {
}
