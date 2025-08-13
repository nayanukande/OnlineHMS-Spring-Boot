package com.nu.room.dto;

import java.time.LocalDate;

public class RoomDTO {
    private Long id;
    private String type;
    private double price;
    private boolean available;
    private int capacity;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    //Constructors
    public RoomDTO() {}

    public RoomDTO(Long id, String type, double price, boolean available, int capacity, 
                   LocalDate checkInDate, LocalDate checkOutDate) {
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
