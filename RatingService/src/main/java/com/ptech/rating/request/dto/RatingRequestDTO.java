package com.ptech.rating.request.dto;

import lombok.Data;

/*
 * @project RatingService
 * @auther Prash on 09-04-2023
 *
 */
@Data
public class RatingRequestDTO {
    private Integer id;
    private Integer userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
