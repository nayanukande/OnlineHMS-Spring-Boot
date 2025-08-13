package com.nu.reservation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.reservation.entity.Reservation;
import com.nu.reservation.service.ReservationService;
import java.util.List;

@RestController
@RequestMapping("/receptionist/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    //Create a new reservation
    @PostMapping("/createReservation")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    //Get all reservations
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    //Get a reservation by ID
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }
}
