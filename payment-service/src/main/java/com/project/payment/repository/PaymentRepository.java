package com.project.payment.repository;

import com.project.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.paymentId =:paymentId")
    Payment getPaymentById(@Param("paymentId") Long paymentId);
}
