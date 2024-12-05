package com.project.TopTierRentals.services;

import com.project.TopTierRentals.dtos.request.InventoryQuantityRequest;
import com.project.TopTierRentals.dtos.response.InventoryQuantityResponse;
import com.project.TopTierRentals.models.Inventory;
import com.project.TopTierRentals.models.Vendor;
import com.project.TopTierRentals.repositories.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryQuantityResponse inventoryCount(InventoryQuantityRequest request) {
        Inventory inventory = new Inventory();
        inventory.setVendorProduct((List<Vendor>) request.getGetVendorProduct());
        inventory.setInventoryId(request.getInventoryId());
        inventory.setStoreLocation(request.getStoreLocation());
        inventory.setQuantity(request.getQuantity());
        inventoryRepository.save(inventory);
        InventoryQuantityResponse response = new InventoryQuantityResponse();
        response.setInventoryQuantity(inventory.getQuantity());
        return response;
    }
}
