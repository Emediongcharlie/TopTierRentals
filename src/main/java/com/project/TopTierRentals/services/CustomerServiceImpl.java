package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.BookingRequest;
import com.project.TopTierRentals.dtos.request.CustomerLoginRequest;
import com.project.TopTierRentals.dtos.request.CustomerRegisterRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.BookingResponse;
import com.project.TopTierRentals.dtos.response.CustomerLoginResponse;
import com.project.TopTierRentals.dtos.response.CustomerRegisterResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.exceptions.EmailValidationException;
import com.project.TopTierRentals.exceptions.NotSuccessfulException;
import com.project.TopTierRentals.exceptions.ProductNotFoundException;
import com.project.TopTierRentals.models.Booking;
import com.project.TopTierRentals.models.Customer;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.repositories.BookingRepository;
import com.project.TopTierRentals.repositories.CustomerRepository;
import com.project.TopTierRentals.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final BookingRepository bookingRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public SearchProductResponse searchProduct(String productName) {
        productService.searchProductByName(productName);
        SearchProductResponse response = new SearchProductResponse();
        response.setProductName(productName);
        return response;
    }

    public List<Booking> createBooking(BookingRequest request) {
        List<Booking> bookings = new ArrayList<>();
        for(Booking booking : bookingRepository.findAll()) {
            if (booking.getProductName().equals(request.getProductName())) {
                BookingResponse response = new BookingResponse();
                response.setCustomerName(response.getCustomerName());
                response.setBookingAmount(request.getBookingAmount());
                bookings.add(booking);
            }
        }
        return bookings;
    }

    @Override
    public CustomerRegisterResponse registerCustomer(CustomerRegisterRequest request) {
        Customer customer = new Customer();
        emailValidation(request.getCustomerEmail());
        customer.setCustomerId(request.getCustomerId());
        customer.setCustomerName(request.getCustomerName());
        customer.setCustomerAddress(request.getCustomerAddress());
        customer.setCustomerEmail(request.getCustomerEmail());
        customer.setCustomerPhone(request.getCustomerPhone());
        customer.setCustomerPassword(request.getCustomerPassword());
        customerRepository.save(customer);
        CustomerRegisterResponse response = new CustomerRegisterResponse();
        response.setMessage("Customer registered");
        return response;
    }

    @Override
    public CustomerLoginResponse CustomerLogin(CustomerLoginRequest request) {
        Customer customer = new Customer();
        emailLoginValidation(request.getEmail());
        customer.setCustomerEmail(request.getEmail());
        customer.setCustomerPassword(request.getPassword());
        customerRepository.save(customer);
        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setMessage("Customer logged in");
        return response;
    }

    public void emailValidation(String email) {
        Optional<Customer> adminOptional = customerRepository.findByCustomerEmail(email);
        if(adminOptional.isPresent()){
            throw new EmailValidationException("Email exist already");
        }
    }

    public void emailLoginValidation(String email) {
        Optional<Customer> adminOptional = customerRepository.findByCustomerEmail(email);
        if(!adminOptional.isPresent()){
            throw new EmailValidationException("Email does not exist");
        }
    }


    public List<Product> getProductByPrice(SearchProductRequest searchProductRequest) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if(product.getProductPrice().equals(searchProductRequest.getProductPrice())){
                productList.add(product);
            }
        }
        return productList;
    }

    public List<Product> findProductByLocation(SearchProductRequest request) {
        List<Product> productLocation = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if(product.getLocation().equals(request.getLocation())){
                productLocation.add(product);
            }
        }
        return productLocation;
    }

    public List<Product> findProductByNameAndCreateBooking(SearchProductRequest request){
        List <Product> findAndCreateByName = new ArrayList<>();
        for(Product product : productRepository.findAll()){
            if(product.getProductName().equals(request.getProductName())) {
                findAndCreateByName.add(product);
            }
        }
        return  findAndCreateByName;
    }


}
