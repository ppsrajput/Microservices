package com.ptech.rating.service;

import com.ptech.rating.entities.Rating;

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
public interface RatingService {

    Rating create(Rating rating);
    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(Integer id);
    List<Rating> getRatingByHotelId(String id);


}
