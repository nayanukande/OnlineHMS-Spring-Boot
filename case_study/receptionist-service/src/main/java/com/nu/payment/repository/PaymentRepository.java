package com.nu.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nu.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
