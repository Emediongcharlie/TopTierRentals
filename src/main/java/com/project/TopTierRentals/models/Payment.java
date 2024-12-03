package com.project.TopTierRentals.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private int customerId;
    private int RentalId;
    private String paymentDate;
    private BigDecimal paymentAmount;
    private PaymentStatus paymentStatus;

}
