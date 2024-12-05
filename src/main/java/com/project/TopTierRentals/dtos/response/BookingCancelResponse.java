package com.project.TopTierRentals.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookingCancelResponse {

    private Long bookingId;
    private String bookingStatus;

    private String message;
}
