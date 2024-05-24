package com.aman.dto;

import lombok.Data;

@Data
public class HotelResponse {
    private Long id;
    private String name;
    private String location;
    private String description;
    private int numberOfAvailableRooms;

    // getters and setters
}
