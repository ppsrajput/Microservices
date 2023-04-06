package com.ptech.hotel.service.impl;

import com.ptech.hotel.entities.Hotel;
import com.ptech.hotel.repositories.HotelRepository;
import com.ptech.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @project HotelService
 * @auther Prash on 06-04-2023
 *
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel create(Hotel hotel) {
        return this.repository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.repository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return this.repository.findById(id).get();
    }
}
