package com.project.payment.service;

import com.project.payment.domain.Payment;
import com.project.payment.enumerator.PaymentMethod;
import com.project.payment.repository.PaymentRepository;

import com.project.base.exception.BusinessException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(Long id) {
        Payment  payment = paymentRepository.getPaymentById(id);

        if(payment != null)
            throw new BusinessException("Payment with id " + id + " already exists");
        else
            return payment;
    }

    @Override
    public void savePayment(Long bookingId, BigDecimal amount) {
    }
}
