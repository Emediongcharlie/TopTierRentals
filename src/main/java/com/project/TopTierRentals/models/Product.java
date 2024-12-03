package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private Boolean Availability;
    private String Category;
    private Condition condition;
    @OneToMany
    private List<Vendor> vendor;
    @OneToMany
    private List<Inventory> inventoryCount;


}
