package com.nu.rate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.rate.entity.SetRates;
import java.time.LocalDate;
import java.util.Optional;

public interface SetRatesRepository extends JpaRepository<SetRates, Long> {
    Optional<SetRates> findByCheckInDateAndCheckOutDateAndNumGuestsAndRoomType(
        LocalDate checkIn, LocalDate checkOut, int numGuests, String roomType);
}
