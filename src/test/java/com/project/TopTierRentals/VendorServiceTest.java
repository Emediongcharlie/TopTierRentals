package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.VendorLoginRequest;
import com.project.TopTierRentals.dtos.request.VendorRegisterRequest;
import com.project.TopTierRentals.dtos.response.VendorLoginResponse;
import com.project.TopTierRentals.dtos.response.VendorRegisterResponse;
import com.project.TopTierRentals.services.VendorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VendorServiceTest {

    @Autowired
    private VendorService vendorService;

    @Test
    public void testVendorCanRegister(){
        VendorRegisterRequest request = new VendorRegisterRequest();
        request.setVendorName("John");
        request.setVendorEmail("email@email.com");
        request.setVendorPassword("password");
        request.setVendorAddress("Lagos");
        request.setVendorPhoneNumber("123456789");
        VendorRegisterResponse response = vendorService.RegisterVendor(request);
        assertNotNull(response);
    }

    @Test
    public void testVendorCanLogin(){
        VendorLoginRequest request = new VendorLoginRequest();
        request.setEmail("email@email.com");
        request.setPassword("password");
        VendorLoginResponse response = vendorService.LoginVendor(request);
        assertNotNull(response);
    }
}
