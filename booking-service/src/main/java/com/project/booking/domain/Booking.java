package com.project.booking.domain;

import com.project.base.dto.BookingStatus;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Column(nullable = true, name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    @OneToMany(mappedBy = "booking")
    private List<BookingSolution> solutions;

    public Booking(Long bookingId, Long userId, BigDecimal totalAmount, BookingStatus status, List<BookingSolution> solutions, Date bookingDate) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.solutions = solutions;
        this.bookingDate = bookingDate;
    }

    public Booking() {}

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<BookingSolution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<BookingSolution> solutions) {
        this.solutions = solutions;
    }
}
