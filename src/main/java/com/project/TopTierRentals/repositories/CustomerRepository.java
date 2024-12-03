package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
