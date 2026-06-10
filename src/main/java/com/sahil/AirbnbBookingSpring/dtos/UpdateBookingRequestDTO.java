package com.sahil.AirbnbBookingSpring.dtos;

import com.sahil.AirbnbBookingSpring.enums.BookingStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBookingRequestDTO {
    @NotNull(message = "Booking ID is required")
    private Long id;

    @NotNull(message = "Idempotency key is required")
    private String idempotencyKey;

    @NotNull(message = "Booking status is required")
    private BookingStatus bookingStatus;
}
