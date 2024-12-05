package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.RentalStatus;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BookingCancelRequest {

    private int bookingId;
    private RentalStatus rentalStatus;
}
