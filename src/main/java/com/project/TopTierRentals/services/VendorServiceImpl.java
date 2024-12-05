package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.VendorLoginRequest;
import com.project.TopTierRentals.dtos.request.VendorRegisterRequest;
import com.project.TopTierRentals.dtos.response.VendorLoginResponse;
import com.project.TopTierRentals.dtos.response.VendorRegisterResponse;
import com.project.TopTierRentals.exceptions.EmailValidationException;
import com.project.TopTierRentals.models.Vendor;
import com.project.TopTierRentals.repositories.VendorsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService{

    private final VendorsRepository vendorsRepository;

    @Override
    public VendorRegisterResponse RegisterVendor(VendorRegisterRequest request) {
        Vendor vendor = new Vendor();
        emailValidation(request.getVendorEmail());
        vendor.setVendorId(request.getVendorId());
        vendor.setVendorName(request.getVendorName());
        vendor.setVendorAddress(request.getVendorAddress());
        vendor.setEmail(request.getVendorEmail());
        vendor.setVendorPassword(request.getVendorPassword());
        vendorsRepository.save(vendor);
        VendorRegisterResponse response = new VendorRegisterResponse();
        response.setMessage("Successfully registered vendor");
        return response;
    }

    @Override
    public VendorLoginResponse LoginVendor(VendorLoginRequest request) {
        Vendor vendor = new Vendor();
        emailLoginValidation(request.getEmail());
        vendor.setEmail(request.getEmail());
        vendor.setVendorPassword(request.getPassword());
        vendorsRepository.save(vendor);
        VendorLoginResponse response = new VendorLoginResponse();
        response.setMessage("Successfully logged in vendor");
        return response;
    }

    public void emailValidation(String email) {
        Optional<Vendor> adminOptional = vendorsRepository.findByEmail(email);
        if(adminOptional.isPresent()){
            throw new EmailValidationException("Email exist already");
        }
    }

    public void emailLoginValidation(String email) {
        Optional<Vendor> adminOptional = vendorsRepository.findByEmail(email);
        if(!adminOptional.isPresent()){
            throw new EmailValidationException("Email does not exist");
        }
    }
}
