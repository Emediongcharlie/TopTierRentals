package com.project.TopTierRentals.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DeleteProductRequest {

    private int productId;
    private String productName;
    private String VendorName;
}
