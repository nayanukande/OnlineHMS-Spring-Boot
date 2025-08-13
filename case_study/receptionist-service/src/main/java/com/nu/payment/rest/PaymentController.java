package com.nu.payment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nu.payment.entity.Payment;
import com.nu.payment.service.PaymentService;
import java.util.List;

@RestController
@RequestMapping("/receptionist/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //Add Payment
    @PostMapping("/addPayment")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    //Get All Payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    //Get Payment by ID
    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
}
