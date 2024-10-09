package com.icwd.hotel.service;

import com.icwd.hotel.entities.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotel(String hotelId);

    List<Hotel> getAllHotels();

}
