package com.nu.room.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    private Long id;

    @Column(nullable = false)
    private String type; // Example: "Deluxe", "Suite", "Standard"

    @Column(nullable = false)
    private double price; // Room price per night

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean available; // true = available, false = booked

    @Column(nullable = false)
    private int capacity; // Maximum number of guests allowed

    @Column(nullable = true)
    private LocalDate checkInDate; // The date when a guest checks in

    @Column(nullable = true)
    private LocalDate checkOutDate; // The date when a guest checks out

    //Constructors
    public Room() {}

    public Room(Long id, String type, double price, boolean available, int capacity, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.available = available;
        this.capacity = capacity;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }
}
