package com.ptech.rating.repositories;

import com.ptech.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByUserId(Integer id);
    List<Rating> findByHotelId(String id);
}
