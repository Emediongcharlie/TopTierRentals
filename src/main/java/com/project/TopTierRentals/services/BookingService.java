package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.BookingCancelRequest;
import com.project.TopTierRentals.dtos.request.BookingRequest;
import com.project.TopTierRentals.dtos.request.BookingUpdateRequest;
import com.project.TopTierRentals.dtos.response.BookingCancelResponse;
import com.project.TopTierRentals.dtos.response.BookingResponse;
import com.project.TopTierRentals.dtos.response.BookingUpdateResponse;
import com.project.TopTierRentals.exceptions.NotSuccessfulException;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request) throws NotSuccessfulException;

    BookingCancelResponse cancelBooking(BookingCancelRequest request);

    BookingUpdateResponse updateBooking(BookingUpdateRequest request);
}
