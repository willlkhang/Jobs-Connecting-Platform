package com.project.payment.domain;

import com.project.payment.enumerator.PaymentMethod;

import jakarta.persistence.*;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Long bookingId;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

}
