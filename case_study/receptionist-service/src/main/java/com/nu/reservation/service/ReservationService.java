package com.nu.reservation.service;

import com.nu.reservation.entity.Reservation;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation getReservationById(Long id);
    void deleteReservationById(Long id);
}
