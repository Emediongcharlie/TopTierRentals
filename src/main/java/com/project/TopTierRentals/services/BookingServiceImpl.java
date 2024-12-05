package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.BookingCancelRequest;
import com.project.TopTierRentals.dtos.request.BookingRequest;
import com.project.TopTierRentals.dtos.request.BookingUpdateRequest;
import com.project.TopTierRentals.dtos.response.BookingCancelResponse;
import com.project.TopTierRentals.dtos.response.BookingResponse;
import com.project.TopTierRentals.dtos.response.BookingUpdateResponse;
import com.project.TopTierRentals.exceptions.BookingCancellationException;
import com.project.TopTierRentals.exceptions.NotSuccessfulException;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.PaymentStatus;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.models.RentalStatus;
import com.project.TopTierRentals.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingResponse createBooking(BookingRequest request) throws NotSuccessfulException {
        Booking booking = new Booking();
        paymentStatusValidation(request.getPaymentStatus());
        rentalStatusValidation(request.getBookingStatus());
        booking.setCustomerName(request.getCustomerName());
        booking.setBookingAmount(request.getBookingAmount());
        booking.setPaymentStatus(request.getPaymentStatus());
        booking.setStartDateAndTime(LocalDateTime.now());
        booking.setEndDateAndTime(request.getEndDateAndTime().plusDays(2));
        booking.setBookingStatus(request.getBookingStatus());
        booking.setBookingLocation(request.getBookingLocation());
        booking.setProductName(request.getProductName());
        bookingRepository.save(booking);
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setCustomerName(booking.getCustomerName());
        bookingResponse.setBookingAmount(booking.getBookingAmount());
        bookingResponse.setPaymentStatus(booking.getPaymentStatus());
        bookingResponse.setStartDateAndTime(LocalDateTime.now());
        bookingResponse.setEndDateAndTime(request.getEndDateAndTime().plusDays(2));
        bookingResponse.setBookingStatus(booking.getBookingStatus());
        bookingResponse.setBookingLocation(booking.getBookingLocation());
        return bookingResponse;
    }

    @Override
    public BookingCancelResponse cancelBooking(BookingCancelRequest request){
        Optional<Booking> bookingOptional = bookingRepository.findByBookingID((long) request.getBookingId());
        BookingCancelResponse response = new BookingCancelResponse();
        if(!bookingOptional.isPresent()){
            throw new BookingCancellationException("Booking not found");
        }
        bookingRepository.delete(bookingOptional.get());
        response.setMessage("Cancelled successfully");
        return response;
    }

    @Override
    public BookingUpdateResponse updateBooking(BookingUpdateRequest request) {
        return null;
    }

    public void paymentStatusValidation(PaymentStatus paymentStatus) throws NotSuccessfulException {
        if(PaymentStatus.FAILED.equals(paymentStatus)){
            throw new NotSuccessfulException("Payment not successful");
        }
        if(PaymentStatus.PENDING.equals(paymentStatus)){
            throw new NotSuccessfulException("Payment in process");
        }
    }

    public void rentalStatusValidation(RentalStatus rentalStatus) throws NotSuccessfulException {
        if(RentalStatus.CANCELLED.equals(rentalStatus)){
            throw new NotSuccessfulException("Booking cancelled");
        }
        if(RentalStatus.OVERDUE.equals(rentalStatus)){
            throw new NotSuccessfulException("Booking overdue");
        }
    }


}
