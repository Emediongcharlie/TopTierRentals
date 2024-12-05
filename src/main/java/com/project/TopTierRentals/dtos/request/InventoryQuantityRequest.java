package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.Vendor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InventoryQuantityRequest {

    private int quantity;
    private int customerId;
    private Long inventoryId;
    private String storeLocation;
    List<Vendor> getVendorProduct;

}
