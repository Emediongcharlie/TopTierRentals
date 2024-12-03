package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
