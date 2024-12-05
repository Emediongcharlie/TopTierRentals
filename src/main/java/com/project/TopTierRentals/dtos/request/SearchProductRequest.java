package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.Vendor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SearchProductRequest {

    private String productName;
    private BigDecimal productPrice;
    private String vendorName;
    private String location;
}
