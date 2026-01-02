package com.project.payment.service;

import com.project.payment.enumerator.PaymentStatus;

import com.project.payment.domain.Payment;
import java.math.BigDecimal;

public interface PaymentService {

    Payment getPaymentById(Long id);

    void savePayment(Long bookingId, BigDecimal amount);

    void updatePaymentStatus(Long bookingId, PaymentStatus status);

}
