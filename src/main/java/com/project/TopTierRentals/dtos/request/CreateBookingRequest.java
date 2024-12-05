package com.project.TopTierRentals.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingRequest {

    private Long bookingId;
    private Long customerId;
    private String customerName;
    private String productName;
}
