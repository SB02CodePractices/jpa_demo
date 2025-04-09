package com.sb02.jpa_demo.controller;

public record ProductCreateDto(
        String name,
        int price,
        String category,
        boolean inStock,
        String description
) {
}
