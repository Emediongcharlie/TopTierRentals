package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingUpdateRequest {

    private Product addedProduct;
}
