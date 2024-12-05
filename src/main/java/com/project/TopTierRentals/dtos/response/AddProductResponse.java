package com.project.TopTierRentals.dtos.response;


import com.project.TopTierRentals.models.Product;
import com.project.TopTierRentals.models.ProductCondition;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductResponse {

    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private boolean availability;
    private String category;
    private ProductCondition productCondition;
    private Long vendorId;
    private int noInStock;
    private String location;
    private String message;
}
