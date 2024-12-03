package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    private int customerID;
    private String customerName;
    private String startDateAndTime;
    private String endDateAndTime;
    private String bookingLocation;
    private RentalStatus bookingStatus;
    private PaymentStatus paymentStatus;
    private String bookingType;
    private BigDecimal bookingAmount;
    @OneToMany
    private List<Product> product;

}
