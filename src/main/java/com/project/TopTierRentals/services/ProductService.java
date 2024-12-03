package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);
}
