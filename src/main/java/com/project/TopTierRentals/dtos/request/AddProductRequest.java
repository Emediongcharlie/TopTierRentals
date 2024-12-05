package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.ProductCondition;
import com.project.TopTierRentals.models.Vendor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductRequest {

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
}
