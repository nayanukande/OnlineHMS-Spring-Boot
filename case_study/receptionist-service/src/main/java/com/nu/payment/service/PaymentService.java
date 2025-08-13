package com.nu.payment.service;

import com.nu.payment.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
}
