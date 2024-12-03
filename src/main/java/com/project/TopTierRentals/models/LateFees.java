package com.project.TopTierRentals.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter@Entity
public class LateFees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerId;
    private BigDecimal lateFee;
    private String message;
}
