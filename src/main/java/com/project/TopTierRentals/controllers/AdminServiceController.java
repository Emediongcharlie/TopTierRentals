package com.project.TopTierRentals.controllers;

import com.project.TopTierRentals.dtos.request.AdminLoginRequest;
import com.project.TopTierRentals.dtos.request.AdminRegisterRequest;
import com.project.TopTierRentals.dtos.response.AdminLoginResponse;
import com.project.TopTierRentals.dtos.response.AdminRegisterResponse;
import com.project.TopTierRentals.models.Admin;
import com.project.TopTierRentals.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AdminServiceController {

    @Autowired
    private final AdminService adminService;

    @PostMapping("/register_admin")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminRegisterRequest registerRequest) {
        try{
            AdminRegisterResponse response = adminService.RegisterAdmin(registerRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login_admin")
    public ResponseEntity<?> loginAdmin(@RequestBody AdminLoginRequest loginRequest) {
        try{
            AdminLoginResponse response = adminService.AdminLogin(loginRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


