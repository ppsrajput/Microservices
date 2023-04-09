package com.ptech.rating.service;

import com.ptech.rating.entities.Rating;
import com.ptech.rating.request.dto.RatingRequestDTO;

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
public interface RatingService {

    Rating create(RatingRequestDTO ratingRequestDTO);
    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(Integer id);
    List<Rating> getRatingByHotelId(String id);


    void deleteRating(Integer id);
}
