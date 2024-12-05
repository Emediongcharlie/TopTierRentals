package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.AddProductRequest;
import com.project.TopTierRentals.dtos.request.SearchProductRequest;
import com.project.TopTierRentals.dtos.response.AddProductResponse;
import com.project.TopTierRentals.dtos.response.DeleteProductResponse;
import com.project.TopTierRentals.dtos.response.SearchProductResponse;
import com.project.TopTierRentals.exceptions.ProductNotFoundException;
import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = new Product();
//        validateStock(addProductRequest.getNoInStock());
        product.setProductName(addProductRequest.getProductName());
        product.setProductDescription(addProductRequest.getProductDescription());
        product.setProductPrice(addProductRequest.getProductPrice());
        product.setAvailability(addProductRequest.isAvailability());
        product.setProductCondition(addProductRequest.getProductCondition());
        product.setProductQuantity(addProductRequest.getProductQuantity());
        product.setVendorId(addProductRequest.getVendorId());
        product.setLocation(addProductRequest.getLocation());
        product.setNoInStock(addProductRequest.getNoInStock());
        productRepository.save(product);
        AddProductResponse addProductResponse = new AddProductResponse();
        addProductResponse.setMessage("Product added successfully");
        return addProductResponse;
    }


    @Override
    public SearchProductResponse searchProductByName(String productName) {
        Optional<Product> foundProduct =productRepository.findByProductName(productName);
        SearchProductResponse searchProductResponse = new SearchProductResponse();
        if(!foundProduct.isPresent()){
            throw new ProductNotFoundException("Product not found");
        }
        searchProductResponse.setProductName(productName);
        return searchProductResponse;
    }

    @Override
    public List<Product> getProductByPrice(SearchProductRequest searchProductRequest) {
        List<Product> productList = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if(product.getProductPrice().equals(searchProductRequest.getProductPrice())){
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public List<Product> findProductByLocation(SearchProductRequest request) {
        List<Product> productLocation = new ArrayList<>();
        for (Product product : productRepository.findAll()) {
            if(product.getLocation().equals(request.getLocation())){
                productLocation.add(product);
            }
        }
        return productLocation;
    }

    @Override
    public DeleteProductResponse deleteProductByProductName(String productName) {
        Optional<Product> foundProduct =productRepository.findByProductName(productName);
        DeleteProductResponse response = new DeleteProductResponse();
        if(!foundProduct.isPresent()){
            throw new ProductNotFoundException("Product not found");
        }
        productRepository.delete(foundProduct.get());
        response.setMessage("Product deleted successfully");
        return response;
    }

    @Override
    public List<Product> findAllProducts(SearchProductRequest request) {
        List<Product> productList = productRepository.findAll();
        return productList;
    }



}
