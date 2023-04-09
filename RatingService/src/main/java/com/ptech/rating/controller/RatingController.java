package com.ptech.rating.controller;

import com.ptech.rating.entities.Rating;
import com.ptech.rating.request.dto.RatingRequestDTO;
import com.ptech.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ha

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequestDTO dto){
        return new ResponseEntity<Rating>(this.ratingService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Integer userId){
        return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByUserId(userId), HttpStatus.OK);
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return new ResponseEntity<List<Rating>>(this.ratingService.getAllRatings(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Integer id){
        this.ratingService.deleteRating(id);
        return new ResponseEntity<Void>( HttpStatus.OK);
    }
}
