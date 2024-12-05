package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;
    private String email;
    private String vendorName;
    @OneToMany
    private List<Product> listProduct;
    private String vendorAddress;
    private String vendorPassword;
}
