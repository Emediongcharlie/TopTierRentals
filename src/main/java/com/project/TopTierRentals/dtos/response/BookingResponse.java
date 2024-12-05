package com.project.TopTierRentals.dtos.response;

import com.project.TopTierRentals.models.PaymentStatus;
import com.project.TopTierRentals.models.ProductOrder;
import com.project.TopTierRentals.models.RentalStatus;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter@Setter
public class BookingResponse {

    private Long bookingID;
    private Long customerID;
    private String customerName;
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private String bookingLocation;
    private RentalStatus bookingStatus;
    private PaymentStatus paymentStatus;
    private String bookingType;
    private BigDecimal bookingAmount;
    @OneToMany
    private List<ProductOrder> orders;
    private String message;
}
