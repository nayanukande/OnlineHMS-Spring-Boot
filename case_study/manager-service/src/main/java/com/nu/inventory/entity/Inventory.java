package com.nu.inventory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(unique = true, nullable = false)
    private String inventoryCode;  // Unique inventory identifier

    @Column(nullable = false)
    private String itemName; // Name of the inventory item

    @Column(nullable = false)
    private String category; // Category (Furniture, Food, Cleaning Supplies)

    @Min(0)
    @Column(nullable = false)
    private int quantity; // Number of available items

    @Column(nullable = false)
    private String supplier; // Supplier providing the inventory

    @Min(0)
    @Column(nullable = false)
    private double pricePerUnit; // Cost per item

    @Column(nullable = false)
    private LocalDate purchaseDate; // Date the inventory was acquired

    public Inventory() {}

    public Inventory(String inventoryCode, String itemName, String category, int quantity, String supplier, double pricePerUnit, LocalDate purchaseDate) {
        this.inventoryCode = inventoryCode;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.supplier = supplier;
        this.pricePerUnit = pricePerUnit;
        this.purchaseDate = purchaseDate;
    }

    //Getters and Setters
    public String getInventoryCode() { return inventoryCode; }
    public void setInventoryCode(String inventoryCode) { this.inventoryCode = inventoryCode; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
}
