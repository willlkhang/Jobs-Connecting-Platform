package com.project.payment.repository;

import com.project.payment.domain.Payment;
import com.project.payment.enumerator.PaymentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.paymentId =:paymentId")
    Payment getPaymentById(@Param("paymentId") Long paymentId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Payment p SET p.paymentStatus =: status WHERE p.paymentId =: paymentId")
    void updatePaymentStatus(@Param("paymentId") Long paymentId, @Param("status") PaymentStatus status);

}
