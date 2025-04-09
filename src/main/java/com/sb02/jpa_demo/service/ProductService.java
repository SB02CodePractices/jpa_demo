package com.sb02.jpa_demo.service;


import com.sb02.jpa_demo.entity.Product;
import com.sb02.jpa_demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    public void saveProduct(
            String name,
            int price,
            String category,
            boolean inStock,
            String description
    ) {
        Product product = new Product(name, price, category, inStock, description);
        productRepository.save(product);
        logger.info("Saved product: {}", product.getId());
    }

    public List<Product> searchProductByKeyword(String keyword) {
        return productRepository.findByCategoryOrNameContainingIgnoreCase(keyword, keyword);
    }

    public Page<Product> getProductsByCategory(String category, int page, int size) {
        return productRepository.findByCategory(category, PageRequest.of(page, size));
    }
}
