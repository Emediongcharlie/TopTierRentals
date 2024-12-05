package com.project.TopTierRentals.dtos.response;


import com.project.TopTierRentals.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductResponse {

    private Product addedProduct;
    private String message;
}
