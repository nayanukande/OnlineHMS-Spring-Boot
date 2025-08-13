package com.nu.reservation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    private Long id;  // Manually assigned ID

    @Column(nullable = false, unique = true)
    private String code; // Unique reservation code

    @Column(nullable = false)
    private String guestName;

    @Column(nullable = false)
    private int numAdults;

    @Column(nullable = false)
    private int numChildren;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private String status; // "Pending", "Confirmed", "Cancelled"

    @Column(nullable = false)
    private int numNights;

    public Reservation() {}

    public Reservation(Long id, String code, String guestName, int numAdults, int numChildren,
                       LocalDate checkInDate, LocalDate checkOutDate, String status) {
        this.id = id;
        this.code = code;
        this.guestName = guestName;
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.numNights = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    //Getters and Setters
    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getGuestName() { return guestName; }
    public int getNumAdults() { return numAdults; }
    public int getNumChildren() { return numChildren; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public String getStatus() { return status; }
    public int getNumNights() { return numNights; }

    public void setStatus(String status) { this.status = status; }
}
