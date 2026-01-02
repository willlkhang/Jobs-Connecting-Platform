package com.project.booking.repository;

import com.project.base.dto.BookingStatus;

import com.project.booking.domain.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.userId =:userId")
    List<Booking> findBookingByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Booking b SET b.status =:status WHERE b.bookingId =:bookingId")
    void updateBookingStatus(@Param("bookingId") Long bookingId, @Param("status") BookingStatus status);
}
