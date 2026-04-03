package com.sahil.AirbnbBookingSpring.repositories.writes;

import com.sahil.AirbnbBookingSpring.models.Airbnb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirbnbWriteRepository extends JpaRepository<Airbnb,Long> {
    Optional<Airbnb> findById(Long id);
}
