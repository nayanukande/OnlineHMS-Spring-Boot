package com.nu.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.reservation.entity.Reservation;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByCode(String code);
}
