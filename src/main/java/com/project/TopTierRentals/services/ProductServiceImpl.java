package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
        product.setProductName(addProductRequest.getProductName());
        product.setProductDescription(addProductRequest.getProductDescription());
        product.setProductPrice(addProductRequest.getProductPrice());
        product.setAvailability(addProductRequest.getAvailability());
        productRepository.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setMessage("Product added successfully");
        return addProductResponse;

    }
}
