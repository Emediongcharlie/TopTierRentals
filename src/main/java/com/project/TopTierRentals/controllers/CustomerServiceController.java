package com.project.TopTierRentals.controllers;

import com.project.TopTierRentals.dtos.request.AdminRegisterRequest;
import com.project.TopTierRentals.dtos.request.BookingRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.AdminRegisterResponse;
import com.project.TopTierRentals.dtos.response.BookingResponse;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerServiceController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create_new_booking/")
    public ResponseEntity<?> createNewBooking(@RequestBody SearchProductRequest request) {
        try{
            List <Product> response = customerService.findProductByNameAndCreateBooking(request);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
