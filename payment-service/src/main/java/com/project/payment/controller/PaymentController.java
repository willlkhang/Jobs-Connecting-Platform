package com.project.payment.controller;

import com.project.payment.domain.Payment;
//import com.project.payment.enumerator.PaymentMethod;
import com.project.payment.service.PaymentService;
import com.project.payment.enumerator.PaymentStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public  ResponseEntity<?> getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping("/save")
    public void savePayment(@RequestParam(name = "bookingId") Long bookingId,
                            @RequestParam(name = "price") BigDecimal price){
        paymentService.savePayment(bookingId, price);
    }

    @PostMapping("/update/status")
    public void updatePaymentStatus(@RequestParam(name = "bookingId") Long bookingId,
                                    @RequestParam(name = "status") PaymentStatus status) {
        paymentService.updatePaymentStatus(bookingId, status);
    }
}
