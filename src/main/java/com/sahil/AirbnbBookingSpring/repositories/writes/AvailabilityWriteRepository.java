package com.sahil.AirbnbBookingSpring.repositories.writes;

import com.sahil.AirbnbBookingSpring.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AvailabilityWriteRepository extends JpaRepository<Availability,Long> {
    List<Availability> findByBookingId(Long bookingId);

    List<Availability> findByAirbnbId(Long airbnbId);

    // SELECT * FROM availability WHERE airbnb_id = airbnbdId AND date BETWEEN startDate AND endDate;
    List<Availability> findByAirbnbIdAndDateBetween(Long airbnbId, LocalDate startDate, LocalDate endDate);


    // SELECT COUNT(*) FROM availability WHERE airbnb_id = airbnbdId AND date BETWEEN startDate AND endDate AND booking_id IS NOT NULL;
    Long countByAirbnbIdAndDateBetweenAndBookingIdIsNotNull(Long airbnbId, LocalDate startDate, LocalDate endDate);

    // UPDATE availability SET booking_id = bookingId where airbnb_id = airbnbId and date BETWEEN startDate AND endDate;
    @Modifying
    @Query("UPDATE Availability a SET a.bookingId = :bookingId WHERE a.airbnbId = :airbnbId AND a.date BETWEEN :startDate AND :endDate")
    void updateBookingIdByAirbnbIdAndDateBetween(Long bookingId, Long airbnbId, LocalDate startDate, LocalDate endDate);
}
