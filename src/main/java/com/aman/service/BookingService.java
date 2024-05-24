package com.aman.service;

import com.aman.dto.BookingRequest;
import com.aman.entity.Booking;
import com.aman.entity.Hotel;
import com.aman.entity.User;
import com.aman.repository.BookingRepository;
import com.aman.repository.HotelRepository;
import com.aman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookRoom(Long hotelId, BookingRequest bookingRequest) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
        if (hotel.getNumberOfAvailableRooms() <= 0) throw new RuntimeException("No available rooms, book oyo");
        hotel.setNumberOfAvailableRooms(hotel.getNumberOfAvailableRooms() - 1);
        hotelRepository.save(hotel);
        User user = userRepository.findById(bookingRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setUser(user);
        booking.setStartDate(bookingRequest.getStartDate());
        booking.setEndDate(bookingRequest.getEndDate());
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        Hotel hotel = booking.getHotel();
        hotel.setNumberOfAvailableRooms(hotel.getNumberOfAvailableRooms() + 1);
        hotelRepository.save(hotel);
        bookingRepository.delete(booking);
    }
}

