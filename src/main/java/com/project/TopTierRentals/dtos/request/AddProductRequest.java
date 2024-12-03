package com.project.TopTierRentals.dtos.request;

import com.project.TopTierRentals.models.Condition;
import com.project.TopTierRentals.models.Inventory;
import com.project.TopTierRentals.models.Vendor;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AddProductRequest {

    private Long productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private int productQuantity;
    private Boolean Availability;
    private String Category;
    private Condition condition;
    @OneToMany
    private List<Vendor> vendorId;
    @OneToMany
    private List<Inventory> inventoryCount;
}
