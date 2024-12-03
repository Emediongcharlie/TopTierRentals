package com.project.TopTierRentals.repositories;

import com.project.TopTierRentals.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
