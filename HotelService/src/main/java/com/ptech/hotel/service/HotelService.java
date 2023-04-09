package com.ptech.hotel.service;

import com.ptech.hotel.entities.Hotel;
import com.ptech.hotel.request.dto.HotelRequestDTO;

import java.util.List;

/*
 * @project HotelService
 * @auther Prash on 06-04-2023
 *
 */
public interface HotelService {

    Hotel create(HotelRequestDTO hotel);
    List<Hotel> getAllHotels();
    Hotel getHotelById(String id);
}
