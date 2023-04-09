package com.ptech.hotel.controller;

import com.ptech.hotel.entities.Hotel;
import com.ptech.hotel.request.dto.HotelRequestDTO;
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
 */
@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService service;
    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody HotelRequestDTO hotel){
        return  new ResponseEntity<>(this.service.create(hotel), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> get(@PathVariable String id){
        Hotel hotel = this.service.getHotelById(id);
        return  ResponseEntity.ok(hotel);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = this.service.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }
}
