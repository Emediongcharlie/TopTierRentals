package com.project.TopTierRentals.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SearchProductResponse {

    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private String productImage;
    private String productCategory;
    private String message;
}
