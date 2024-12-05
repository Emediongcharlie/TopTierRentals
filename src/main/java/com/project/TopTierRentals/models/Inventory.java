package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @OneToMany
    private List<Vendor> vendorProduct;
    private int quantity;
    private String storeLocation;
    private String customerId;
}
