package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.AdminLoginRequest;
import com.project.TopTierRentals.dtos.request.AdminRegisterRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.AdminLoginResponse;
import com.project.TopTierRentals.dtos.response.AdminRegisterResponse;
import com.project.TopTierRentals.exceptions.EmailValidationException;
import com.project.TopTierRentals.models.Admin;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Customer;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.repositories.AdminRepository;
import com.project.TopTierRentals.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ProductService productService;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private AdminRepository adminRepository;

    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        productService.addProduct(addProductRequest);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setProductName(addProductRequest.getProductName());
        addProductResponse.setProductDescription(addProductRequest.getProductDescription());
        addProductResponse.setProductPrice(addProductRequest.getProductPrice());
        addProductResponse.setProductQuantity(addProductRequest.getProductQuantity());
        addProductResponse.setVendorId(addProductRequest.getVendorId());
        addProductResponse.setMessage("Product added successfully");
        return addProductResponse;
    }

    public List<Booking> ViewAllBookings(){
        return bookingRepository.findAll();
    }

    @Override
    public AdminRegisterResponse RegisterAdmin(AdminRegisterRequest request) {
        Admin admin = new Admin();
        emailValidation(request.getEmail());
        admin.setEmail(request.getEmail());
        admin.setId(request.getId());
        admin.setName(request.getName());
        admin.setPassword(request.getPassword());
        adminRepository.save(admin);
        AdminRegisterResponse adminRegisterResponse = new AdminRegisterResponse();
        adminRegisterResponse.setName(admin.getName());
        adminRegisterResponse.setMessage("Admin registered successfully");
        return adminRegisterResponse;
    }

    @Override
    public AdminLoginResponse AdminLogin(AdminLoginRequest request) {
        Admin admin = new Admin();
        emailLoginValidation(request.getEmail());
        admin.setEmail(request.getEmail());
        admin.setPassword(request.getPassword());
        adminRepository.save(admin);
        AdminLoginResponse response = new AdminLoginResponse();
        response.setMessage("successful");
        return response;
    }

    public void emailValidation(String email) {
        Optional<Admin> adminOptional = adminRepository.findByEmail(email);
        if(adminOptional.isPresent()){
            throw new EmailValidationException("Email exist already");
        }
    }

    public void emailLoginValidation(String email) {
        Optional<Admin> adminOptional = adminRepository.findByEmail(email);
        if(!adminOptional.isPresent()){
            throw new EmailValidationException("Email does not exist");
        }
    }


}
