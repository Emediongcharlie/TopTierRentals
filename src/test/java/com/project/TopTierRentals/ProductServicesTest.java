package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServicesTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testAddProduct() {
        AddProductRequest addProductRequest = new AddProductRequest();
        addProductRequest.setProductName("test");
        addProductRequest.setProductDescription("Test");
        addProductRequest.setProductPrice(new BigDecimal(15.0));
        addProductRequest.setProductQuantity(5);
        AddProductResponse response = productService.addProduct(addProductRequest);
        assertNotNull(response);

    }
}
