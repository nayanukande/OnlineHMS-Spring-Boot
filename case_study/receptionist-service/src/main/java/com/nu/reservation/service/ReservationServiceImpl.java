package com.nu.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nu.reservation.entity.Reservation;
import com.nu.reservation.repository.ReservationRepository;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation createReservation(Reservation reservation) {
        //Validate Check-in and Check-out Dates
        if (reservation.getCheckInDate().isAfter(reservation.getCheckOutDate())) {
            throw new IllegalArgumentException("Check-out date must be after check-in date.");
        }

        //Validate Guest Count
        if (reservation.getNumAdults() + reservation.getNumChildren() <= 0) {
            throw new IllegalArgumentException("At least one guest is required.");
        }

        //Ensure Manually Assigned ID Does Not Already Exist
        if (reservationRepository.existsById(reservation.getId())) {
            throw new IllegalArgumentException("Reservation ID already exists.");
        }

        //Save Reservation in Database
        return reservationRepository.save(reservation);
    }


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + id));
    }
    
    @Override
    public void deleteReservationById(Long id) {
    	reservationRepository.deleteById(id);
    }
}
