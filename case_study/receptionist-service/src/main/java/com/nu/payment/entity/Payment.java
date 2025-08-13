package com.nu.payment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.nu.payment.security.EncryptionUtil;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private Long id;  // Unique payment ID

    @Column(nullable = false)
    private double total; // Total amount paid

    @Column(nullable = false)
    private LocalDateTime payTime; // Payment timestamp

    @Column(nullable = false)
    private String creditCardNumber; // Encrypted credit card details

    public Payment() {}

    public Payment(double total, LocalDateTime payTime, String creditCardNumber) throws Exception {
        this.total = total;
        this.payTime = payTime;
        this.creditCardNumber = EncryptionUtil.encrypt(creditCardNumber);
    }

    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getPayTime() { return payTime; }
    public void setPayTime(LocalDateTime payTime) { this.payTime = payTime; }

    public String getCreditCardNumber() throws Exception {return EncryptionUtil.decrypt(this.creditCardNumber);} //Decrypt when retrieving

    public void setCreditCardNumber(String creditCardNumber) throws Exception {
        this.creditCardNumber = EncryptionUtil.encrypt(creditCardNumber); //Encrypt before storing
    }
}
