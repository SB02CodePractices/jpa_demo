package com.sb02.jpa_demo.controller;

import com.sb02.jpa_demo.service.ProductInfo;
import com.sb02.jpa_demo.service.ProductService;
import com.sb02.jpa_demo.service.RegisterProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductInfo> registerProduct(
            @RequestBody ProductCreateRequest requestDto
    ) {
        return ResponseEntity.ok(productService.createProduct(productCreateDtoToCommand(requestDto)));
    }

    private RegisterProductCommand productCreateDtoToCommand(ProductCreateRequest requestDto) {
        return new RegisterProductCommand(
                requestDto.name(),
                requestDto.price(),
                requestDto.category(),
                requestDto.inStock(),
                requestDto.description()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInfo> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/_search")
    public ResponseEntity<Page<ProductInfo>> searchProducts(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(productService.searchProductByKeyword(keyword, page, size));
    }

    @GetMapping("/_list")
    public ResponseEntity<Page<ProductInfo>> getProductsByCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(productService.getProductsByCategory(category, page, size));
    }
}
