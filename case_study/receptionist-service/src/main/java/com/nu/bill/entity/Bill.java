package com.nu.bill.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @Column(nullable = false, unique = true)
    private Long billingNo; // Manually assigned Billing No

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double taxes;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String services;

    @Column(nullable = false)
    private String unit;

    public Bill() {}

    public Bill(Long billingNo, int quantity, double price, double taxes, LocalDate date, String services, String unit) {
        this.billingNo = billingNo;
        this.quantity = quantity;
        this.price = price;
        this.taxes = taxes;
        this.totalAmount = (quantity * price) + taxes; //Total Calculation
        this.date = date;
        this.services = services;
        this.unit = unit;
    }

    //Getters and Setters
    public Long getBillingNo() { return billingNo; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public double getTaxes() { return taxes; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDate getDate() { return date; }
    public String getServices() { return services; }
    public String getUnit() { return unit; }

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
    
    
}
