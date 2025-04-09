package com.sb02.jpa_demo.repository;

import com.sb02.jpa_demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategory(String category, Pageable pageable);
    Page<Product> findByCategoryOrNameContainingIgnoreCase(String category, String name, Pageable pageable);
}
