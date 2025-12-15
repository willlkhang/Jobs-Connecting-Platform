package com.project.booking.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "BookingSolution")
public class BookingSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingsolution_id")
    private Long bookingSolutionId;

    @Column(name = "solution_id")
    private Long solutionId;
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "bookingsolution_booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    public BookingSolution(Booking booking, Long solutionId, Long bookingId, Long bookingSolutionId) {
        this.booking = booking;
        this.solutionId = solutionId;
        this.bookingId = bookingId;
        this.bookingSolutionId = bookingSolutionId;
    }

    public BookingSolution() {}

    public Long getBookingSolutionId() {
        return bookingSolutionId;
    }

    public void setBookingSolutionId(Long bookingSolutionId) {
        this.bookingSolutionId = bookingSolutionId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }
}
