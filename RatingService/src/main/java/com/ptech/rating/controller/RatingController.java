package com.ptech.rating.controller;

import com.ptech.rating.entities.Rating;
import com.ptech.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating dto){
        return new ResponseEntity<Rating>(this.ratingService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/rating/users/{userId}")
    public ResponseEntity<List<Rating>> createRating(@PathVariable Integer id){
        return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByUserId(id), HttpStatus.OK);
    }


}
