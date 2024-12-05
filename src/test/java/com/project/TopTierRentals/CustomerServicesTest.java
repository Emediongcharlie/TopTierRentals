package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.*;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.CustomerLoginResponse;
import com.project.TopTierRentals.dtos.response.CustomerRegisterResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.models.ProductCondition;
import com.project.TopTierRentals.services.BookingServiceImpl;
import com.project.TopTierRentals.services.CustomerService;
import com.project.TopTierRentals.services.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerServicesTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Test
    public void testGetProduct() {
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal(2000.9));
        request.setVendorName("John");
        SearchProductResponse response = productServiceImpl.searchProductByName(request.getProductName());
        assertNotNull(response);
        assertEquals(response.getProductName(), "test");
    }

    @Test
    public void testSearchProductByPrice(){
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal("1500.00"));
        request.setVendorName("John");
        List<Product> response = productServiceImpl.getProductByPrice(request);
        assertNotNull(response);
        assertEquals(response.size(), 1);
    }

    @Test
    public void testSearchProductByLocation(){
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal(1500.00));
        request.setVendorName("John");
        request.setLocation("Jos");
        List<Product> response = productServiceImpl.findProductByLocation(request);
        assertNotNull(response);
    }

    @Test
    public void testFindAllProduct(){
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal(1500.00));
        List<Product> response = productServiceImpl.findAllProducts(request);
        assertNotNull(response);
        assertEquals(response.size(), 1);
    }

    @Test
    public void testUserCanBookProduct(){
        BookingRequest request = new BookingRequest();
        request.setProductName("test");
        List<Booking> response = customerService.createBooking(request);
        assertNotNull(response);
    }

    @Test
    public void testCustomerCanRegister(){
        CustomerRegisterRequest request = new CustomerRegisterRequest();
        request.setCustomerId(request.getCustomerId());
        request.setCustomerName("james");
        request.setCustomerAddress("Lagos");
        request.setCustomerPhone(request.getCustomerPhone());
        request.setCustomerEmail("test@test.com");
        request.setCustomerPassword("test");
        CustomerRegisterResponse response = customerService.registerCustomer(request);
        assertNotNull(response);
    }

    @Test
    public void testCustomerCanLogin(){
        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("test@email.com");
        request.setPassword("test");
        CustomerLoginResponse response = customerService.CustomerLogin(request);
        assertNotNull(response);

    }

}
