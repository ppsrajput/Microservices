package com.ptech.hotel.controller;

import com.ptech.hotel.entities.Hotel;
import com.ptech.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @project HotelService
 * @auther Prash on 06-04-2023
 *
 */@RestController
public class HotelController {

    @Autowired
    private HotelService service;
    @PostMapping("/hotel")
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
        return  new ResponseEntity<>(this.service.create(hotel), HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Hotel> get(@PathVariable String id){
        Hotel hotel = this.service.getHotelById(id);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
    @GetMapping("/hotels")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = this.service.getAllHotels();
        return new ResponseEntity<>(hotels,HttpStatus.OK);
    }
}
