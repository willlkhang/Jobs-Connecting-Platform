package com.project.payment.controller;

import com.project.payment.domain.Payment;
import com.project.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/get-payment-by-id")
    public  ResponseEntity<?> getPaymentById(@RequestParam Long paymentId){
        Payment payment = paymentService.getPaymentById(paymentId);
        if(payment == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping("/save-payment")
    public void savePayment(@RequestParam Long bookingId, @RequestParam BigDecimal price){
        paymentService.savePayment(bookingId, price);
    }
}
