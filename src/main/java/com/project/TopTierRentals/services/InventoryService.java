package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.InventoryQuantityRequest;
import com.project.TopTierRentals.dtos.response.InventoryQuantityResponse;

public interface InventoryService {
    InventoryQuantityResponse inventoryCount(InventoryQuantityRequest request);
}
