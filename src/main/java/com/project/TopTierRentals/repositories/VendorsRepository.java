package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Admin;
import com.project.TopTierRentals.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorsRepository extends JpaRepository<Vendor, Long> {

    Optional<Vendor> findByEmail(String email);
}
