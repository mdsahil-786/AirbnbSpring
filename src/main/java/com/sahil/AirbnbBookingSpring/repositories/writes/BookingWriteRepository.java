package com.sahil.AirbnbBookingSpring.repositories.writes;

import com.sahil.AirbnbBookingSpring.models.Airbnb;
import com.sahil.AirbnbBookingSpring.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingWriteRepository extends JpaRepository<Booking,Long>
{
    Optional<Booking> findById(Long id);

    List<Booking> findByAirbnbId(String airbnbId);

    Optional<Booking> findByIdempotencyKey(String idempotencyKey);

    // @Lock(LockModeType.PESSIMISTIC_WRITE)
    // @Query("SELECT b FROM Booking b WHERE b.id = :id")
    // Optional<Booking> findByIdWithLock( @Param("id") Long id);


}
