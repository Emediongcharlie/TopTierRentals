package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.DeleteProductRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.DeleteProductResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    AddProductResponse addProduct(AddProductRequest addProductRequest);


    SearchProductResponse searchProductByName(String productName);

    List<Product> getProductByPrice(SearchProductRequest searchProductRequest);

    List<Product> findProductByLocation(SearchProductRequest request);

//    DeleteProductResponse deleteProductByProductName(DeleteProductRequest request);

    DeleteProductResponse deleteProductByProductName(String productName);

    List<Product> findAllProducts(SearchProductRequest request);

//    List<Product> findProductByLocation(String location);
}
