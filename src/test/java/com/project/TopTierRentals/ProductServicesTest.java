package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.DeleteProductRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.DeleteProductResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.models.ProductCondition;
import com.project.TopTierRentals.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServicesTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("test");
        addProductRequest.setProductDescription("Test");
        addProductRequest.setProductPrice(new BigDecimal(1500.0));
        addProductRequest.setProductQuantity(1);
        addProductRequest.setAvailability(true);
        addProductRequest.setProductCondition(ProductCondition.GOOD);
        addProductRequest.setNoInStock(10);
        addProductRequest.setVendorId(1L);
        addProductRequest.setLocation("Jos");
        AddProductResponse response = productService.addProduct(addProductRequest);
        assertNotNull(response);
        assertEquals("Product added successfully", response.getMessage());
    }

    @Test
    public void testGetProduct(){
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal(2000.9));
        request.setVendorName("John");
        SearchProductResponse response = productService.searchProductByName(request.getProductName());
        assertNotNull(response);
        assertEquals(response.getProductName(), "test");

    }

    @Test
    public void testSearchProductByPrice(){
        SearchProductRequest request = new SearchProductRequest();
        request.setProductName("test");
        request.setProductPrice(new BigDecimal("1500.00"));
        request.setVendorName("John");
        List<Product> response = productService.getProductByPrice(request);
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
        List<Product> response = productService.findProductByLocation(request);
        assertNotNull(response);

    }

    @Test
    public void testDeleteProduct() {
        DeleteProductRequest request = new DeleteProductRequest();
        request.setVendorName("jimmy");
        request.setProductName("test");
        DeleteProductResponse response = productService.deleteProductByProductName(request.getProductName());
        assertNull(response);

    }
}
