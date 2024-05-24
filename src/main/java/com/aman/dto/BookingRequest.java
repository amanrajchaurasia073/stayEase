package com.aman.dto;


import lombok.Data;

@Data
public class BookingRequest {
    private Long userId;
    private String startDate;
    private String endDate;
}
