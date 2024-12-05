package com.project.TopTierRentals;

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
import com.project.TopTierRentals.services.AdminService;
import com.project.TopTierRentals.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private AdminService adminService;

    @Test
    public void testBookingService() throws NotSuccessfulException {
        BookingRequest request = new BookingRequest();
        request.setCustomerName("John Doe");
        request.setBookingLocation("Lagos");
        request.setBookingAmount(new BigDecimal("1000.00"));
        request.setStartDateAndTime(LocalDateTime.now());
        request.setEndDateAndTime(LocalDateTime.now().plusDays(3));
        request.setPaymentStatus(PaymentStatus.COMPLETED);
        request.setBookingStatus(RentalStatus.COMPLETED);
        request.setOrders(request.getOrders());
        request.setProductName("book");
        BookingResponse response = bookingService.createBooking(request);
        assertNotNull(response);
        assertEquals(response.getBookingAmount(), new BigDecimal("1000.00"));
        assertEquals(response.getPaymentStatus(),PaymentStatus.COMPLETED);
    }

    @Test
    public void testBookingCancelled(){
        BookingCancelRequest request = new BookingCancelRequest();
        request.setRentalStatus(RentalStatus.CANCELLED);
        request.setBookingId(2);
        BookingCancelResponse response = bookingService.cancelBooking(request);
        assertNotNull(response);
        assertEquals(response.getMessage(), "Cancelled successfully");
    }

    @Test
    public void testBookingUpdated(){
        BookingUpdateRequest request = new BookingUpdateRequest();
        request.setAddedProduct(request.getAddedProduct());
        BookingUpdateResponse response = bookingService.updateBooking(request);
        assertNotNull(response);
    }

    @Test
    public void testViewAllBookings(){
        List<Booking> response = adminService.ViewAllBookings();
        assertNotNull(response);
        assertEquals(response.size(), 10);
    }
}
