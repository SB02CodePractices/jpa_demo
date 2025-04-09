package com.sb02.jpa_demo.repository;

import com.sb02.jpa_demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryOrNameContainingIgnoreCase(String category, String name);

    Page<Product> findByCategory(String category, Pageable pageable);
}
