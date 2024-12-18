package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);

    List<Product> findByNoInStock(int noInStock);
}
