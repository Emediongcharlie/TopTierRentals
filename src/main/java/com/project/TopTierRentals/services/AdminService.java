package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.AdminLoginRequest;
import com.project.TopTierRentals.dtos.request.AdminRegisterRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.AdminLoginResponse;
import com.project.TopTierRentals.dtos.response.AdminRegisterResponse;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Product;

import java.util.List;

public interface AdminService {

    AddProductResponse addProduct(AddProductRequest addProductRequest);

    List<Booking> ViewAllBookings();

    AdminRegisterResponse RegisterAdmin(AdminRegisterRequest request);

    AdminLoginResponse AdminLogin(AdminLoginRequest request);

}
