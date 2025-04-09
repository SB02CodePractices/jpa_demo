package com.sb02.jpa_demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "address_history",
            joinColumns = @JoinColumn(name = "member_id")
    )
    private List<Address> addressHistory = new ArrayList<>();
}
