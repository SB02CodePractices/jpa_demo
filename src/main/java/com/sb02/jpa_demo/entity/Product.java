package com.sb02.jpa_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "products")
@Setter
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(length = 50)
    private String category;

    @Column(name = "in_stock", nullable = false)
    private boolean inStock;

    @Column(length = 500)
    private String description;

    /*
        Hibernate의 @CreationTimestamp 어노테이션은 엔티티가 생성될 때
        현재 시간을 자동으로 설정해주는 역할을 합니다.
        이 어노테이션은 Hibernate에서 제공하는 기능으로, JPA 표준은 아닙니다.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Version
    private Long version;

    public Product(String name, int price, String category, boolean inStock, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.description = description;
    }
}
