package com.sb02.jpa_demo.service;

import org.springframework.data.domain.Page;

public interface ProductService {
    ProductInfo createProduct(RegisterProductCommand command);
    ProductInfo getProduct(Long id);
    Page<ProductInfo> getProductsByCategory(String category, int page, int size);
    Page<ProductInfo> searchProductByKeyword(String keyword, int page, int size);
}
