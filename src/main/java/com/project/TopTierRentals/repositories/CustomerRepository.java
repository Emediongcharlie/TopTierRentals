package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Admin;
import com.project.TopTierRentals.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCustomerEmail(String email);
}
