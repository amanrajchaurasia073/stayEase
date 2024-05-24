package com.aman.dto;

import lombok.Data;

@Data
public class HotelRequest {
    private String name;
    private String location;
    private String description;
    private int numberOfAvailableRooms;

    // getters and setters
}
