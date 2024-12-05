package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private boolean availability;
    private String category;
    private ProductCondition productCondition;
//    @OneToOne
    private Long vendorId;
    private String vendorName;
    private String location;
    private int noInStock;
}
