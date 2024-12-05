package com.project.TopTierRentals;

import com.project.TopTierRentals.dtos.request.InventoryQuantityRequest;
import com.project.TopTierRentals.dtos.response.InventoryQuantityResponse;
import com.project.TopTierRentals.repositories.InventoryRepository;
import com.project.TopTierRentals.services.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InventoryServiceTest {


    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryService inventoryService;

    @Test
    public void testThatVendorCanCheckProductInventory(){
        InventoryQuantityRequest request = new InventoryQuantityRequest();
        request.setQuantity(7);
        request.setStoreLocation("Lagos");
        InventoryQuantityResponse response = inventoryService.inventoryCount(request);
        assertNotNull(response);
        assertEquals(response.getInventoryQuantity(), 7);
    }


}
