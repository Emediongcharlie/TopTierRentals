package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
