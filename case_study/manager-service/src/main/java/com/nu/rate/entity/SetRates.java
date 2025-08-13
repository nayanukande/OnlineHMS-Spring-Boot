package com.nu.rate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "set_rates")
public class SetRates {
    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Column(nullable = false)
    private String day;  // E.g., "Monday", "Friday"

    @Min(1)
    @Column(nullable = false)
    private int numGuests;

    @Column(nullable = false)
    private String roomType; //New field to apply rates per room type

    @Min(0)
    @Column(nullable = false)
    private double firstNightPrice;

    @Min(0)
    @Column(nullable = false)
    private double extensionPrice;

    public SetRates() {}

    public SetRates(LocalDate checkInDate, LocalDate checkOutDate, String day, int numGuests, String roomType, double firstNightPrice, double extensionPrice) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.day = day;
        this.numGuests = numGuests;
        this.roomType = roomType;
        this.firstNightPrice = firstNightPrice;
        this.extensionPrice = extensionPrice;
    }
    
    //Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getFirstNightPrice() {
		return firstNightPrice;
	}

	public void setFirstNightPrice(double firstNightPrice) {
		this.firstNightPrice = firstNightPrice;
	}

	public double getExtensionPrice() {
		return extensionPrice;
	}

	public void setExtensionPrice(double extensionPrice) {
		this.extensionPrice = extensionPrice;
	}

    
}
