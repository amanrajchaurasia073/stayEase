package com.aman.controller;

import com.aman.dto.BookingRequest;
import com.aman.entity.Booking;
import com.aman.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/hotels/{hotelId}/book")
    public ResponseEntity<Booking> bookRoom(@PathVariable Long hotelId, @RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.bookRoom(hotelId, bookingRequest));
    }

    @PreAuthorize("hasRole('HOTEL_MANAGER')")
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }
}
