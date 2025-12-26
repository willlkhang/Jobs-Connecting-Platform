package com.project.base.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BookingDTO {

    private Long bookingId;
    private Long userId;
    private List<SolutionDTO> solutionIdList;
    private BigDecimal totalAmount;
    private Integer status;
    private Date bookingDate;

    public List<SolutionDTO> getSolutionIdList() {
        return solutionIdList;
    }

    public void setSolutionIdList(List<SolutionDTO> solutionIdList) {
        this.solutionIdList = solutionIdList;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
