package com.sb02.jpa_demo.controller;

import com.sb02.jpa_demo.entity.Product;
import com.sb02.jpa_demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> registerProduct(
            @RequestBody ProductCreateDto productCreateDto
    ) {
        productService.saveProduct(
                productCreateDto.name(),
                productCreateDto.price(),
                productCreateDto.category(),
                productCreateDto.inStock(),
                productCreateDto.description()
        );
        return ResponseEntity.ok().build();
    }

    @GetMapping("/_search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam String keyword
    ) {
        return ResponseEntity.ok(productService.searchProductByKeyword(keyword));
    }

    @GetMapping("/_list")
    public ResponseEntity<Page<Product>> getProductsByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(productService.getProductsByCategory(category, page, size));
    }
}
