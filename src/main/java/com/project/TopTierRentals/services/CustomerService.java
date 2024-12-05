package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.BookingRequest;
import com.project.TopTierRentals.dtos.request.CustomerLoginRequest;
import com.project.TopTierRentals.dtos.request.CustomerRegisterRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.CustomerLoginResponse;
import com.project.TopTierRentals.dtos.response.CustomerRegisterResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Product;

import java.util.List;

public interface CustomerService {

    SearchProductResponse searchProduct(String productName);

    List<Booking> createBooking(BookingRequest bookingRequest);

    CustomerRegisterResponse registerCustomer(CustomerRegisterRequest request);

    CustomerLoginResponse CustomerLogin(CustomerLoginRequest request);

    List<Product> getProductByPrice(SearchProductRequest searchProductRequest);

    List<Product> findProductByLocation(SearchProductRequest request);
}
