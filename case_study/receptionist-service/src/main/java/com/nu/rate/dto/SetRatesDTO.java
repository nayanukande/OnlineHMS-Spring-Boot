package com.nu.rate.dto;

import java.time.LocalDate;

public class SetRatesDTO {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String day;
    private int numGuests;
    private String roomType;
    private double firstNightPrice;
    private double extensionPrice;

    public SetRatesDTO() {}

    public SetRatesDTO(LocalDate checkInDate, LocalDate checkOutDate, String day, int numGuests, String roomType, double firstNightPrice, double extensionPrice) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.day = day;
        this.numGuests = numGuests;
        this.roomType = roomType;
        this.firstNightPrice = firstNightPrice;
        this.extensionPrice = extensionPrice;
    }

    //Getters and Setters
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { this.checkOutDate = checkOutDate; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public int getNumGuests() { return numGuests; }
    public void setNumGuests(int numGuests) { this.numGuests = numGuests; }

    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }

    public double getFirstNightPrice() { return firstNightPrice; }
    public void setFirstNightPrice(double firstNightPrice) { this.firstNightPrice = firstNightPrice; }

    public double getExtensionPrice() { return extensionPrice; }
    public void setExtensionPrice(double extensionPrice) { this.extensionPrice = extensionPrice; }
}
