package com.ptech.user.service.entities;

import lombok.Data;

/*
 * @project UserService
 * @auther Prash on 09-04-2023
 *
 */
@Data
public class Rating {
    private Integer id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
