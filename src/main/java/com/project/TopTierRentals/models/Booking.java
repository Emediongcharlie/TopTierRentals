package com.project.TopTierRentals.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingID;
    private Long customerID;
    private String customerName;
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private String bookingLocation;
    private RentalStatus bookingStatus;
    private PaymentStatus paymentStatus;
    private BigDecimal bookingAmount;
    @OneToMany
    private List<ProductOrder> orders;
    private String productName;

}
