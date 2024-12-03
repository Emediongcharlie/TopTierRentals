package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;
    @ManyToMany
    private List<Product> productId;
    private String quantity;
    private String storeLocation;
}
