package com.ptech.rating.service.impl;

import com.ptech.rating.entities.Rating;
import com.ptech.rating.repositories.RatingRepository;
import com.ptech.rating.request.dto.RatingRequestDTO;
import com.ptech.rating.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */
@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Rating create(RatingRequestDTO ratingRequestDTO) {
        Rating rating = this.modelMapper.map(ratingRequestDTO, Rating.class);
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Integer id) {
        return repository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return repository.findByHotelId(id);
    }

    @Override
    public void deleteRating(Integer id) {
        this.repository.deleteById(id);
    }
}
