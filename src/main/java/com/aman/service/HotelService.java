package com.aman.service;

import com.aman.dto.HotelRequest;
import com.aman.dto.HotelResponse;
import com.aman.entity.Hotel;
import com.aman.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll().stream().map(this::convertToHotelResponse).collect(Collectors.toList());
    }

    public HotelResponse createHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelRequest.getName());
        hotel.setLocation(hotelRequest.getLocation());
        hotel.setDescription(hotelRequest.getDescription());
        hotel.setNumberOfAvailableRooms(hotelRequest.getNumberOfAvailableRooms());

        return convertToHotelResponse(hotelRepository.save(hotel));
    }

    public HotelResponse updateHotel(Long hotelId, HotelRequest hotelRequest) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setName(hotelRequest.getName());
        hotel.setLocation(hotelRequest.getLocation());
        hotel.setDescription(hotelRequest.getDescription());
        hotel.setNumberOfAvailableRooms(hotelRequest.getNumberOfAvailableRooms());

        return convertToHotelResponse(hotelRepository.save(hotel));
    }

    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    private HotelResponse convertToHotelResponse(Hotel hotel) {
        HotelResponse response = new HotelResponse();
        response.setId(hotel.getId());
        response.setName(hotel.getName());
        response.setLocation(hotel.getLocation());
        response.setDescription(hotel.getDescription());
        response.setNumberOfAvailableRooms(hotel.getNumberOfAvailableRooms());
        return response;
    }
}

