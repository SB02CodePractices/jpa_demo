package com.sb02.jpa_demo.service;


import com.sb02.jpa_demo.entity.Product;
import com.sb02.jpa_demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;


    @Override
    @Transactional
    public ProductInfo createProduct(RegisterProductCommand command) {;
        return Optional.ofNullable(command)
                .map(this::productFromCommand)
                .map(productRepository::save)
                .map(this::productInfoFromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Command cannot be null"));
    }

    private Product productFromCommand(RegisterProductCommand command) {
        return new Product(
                command.name(),
                command.price(),
                command.category(),
                command.inStock(),
                command.description()
        );
    }

    private ProductInfo productInfoFromEntity(Product product) {
        return new ProductInfo(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.isInStock(),
                product.getDescription(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    @Override
    public ProductInfo getProduct(Long id) {
        return productRepository.findById(id)
                .map(this::productInfoFromEntity)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @Override
    public Page<ProductInfo> getProductsByCategory(String category, int page, int size) {
        return productRepository.findByCategory(category, pageRequestSortByCreatedAt(page, size))
                .map(this::productInfoFromEntity);
    }

    @Override
    public Page<ProductInfo> searchProductByKeyword(String keyword, int page, int size) {
        return productRepository.findByCategoryOrNameContainingIgnoreCase(keyword, keyword, pageRequestSortByCreatedAt(page, size))
                .map(this::productInfoFromEntity);
    }

    private PageRequest pageRequestSortByCreatedAt(int page, int size) {
        return PageRequest.of(page, size, Sort.by("createdAt").descending());
    }
}
