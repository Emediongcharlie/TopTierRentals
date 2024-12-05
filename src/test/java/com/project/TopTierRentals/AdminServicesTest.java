package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.AdminLoginRequest;
import com.project.TopTierRentals.dtos.request.AdminRegisterRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.AdminLoginResponse;
import com.project.TopTierRentals.dtos.response.AdminRegisterResponse;
import com.project.TopTierRentals.models.ProductCondition;
import com.project.TopTierRentals.services.AdminService;
import com.project.TopTierRentals.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdminServicesTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private AdminService adminService;

    @Test
    public void testAddProduct() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("test");
        addProductRequest.setProductDescription("Test");
        addProductRequest.setProductPrice(new BigDecimal(1500.0));
        addProductRequest.setProductQuantity(5);
        addProductRequest.setAvailability(true);
        addProductRequest.setProductCondition(ProductCondition.GOOD);
        addProductRequest.setNoInStock(10);
        addProductRequest.setVendorId(1L);
        addProductRequest.setLocation("Jos");
        AddProductResponse response = adminService.addProduct(addProductRequest);
        assertNotNull(response);
        assertEquals("Product added successfully", response.getMessage());
    }

    @Test
    public void testAdminCanRegister(){
        AdminRegisterRequest request = new AdminRegisterRequest();
        request.setName("JOHN dOE");
        request.setEmail("john.doe@gmail.com");
        request.setPassword("password");
        AdminRegisterResponse response = adminService.RegisterAdmin(request);
        assertNotNull(response);
    }

    @Test
    public void testAdminCanLogin(){
        AdminLoginRequest request = new AdminLoginRequest();
        request.setEmail("john.doe@gmail.com");
        request.setPassword("password");
        AdminLoginResponse response = adminService.AdminLogin(request);
        assertNotNull(response);
    }
}
