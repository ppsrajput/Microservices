package com.ptech.hotel.entities;

/*
 * @project HotelService
 * @auther Prash on 06-04-2023
 *
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
