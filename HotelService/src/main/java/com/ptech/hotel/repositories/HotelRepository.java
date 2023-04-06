package com.ptech.hotel.repositories;

import com.ptech.hotel.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * @project HotelService
 * @auther Prash on 06-04-2023
 *
 */
public interface HotelRepository extends MongoRepository<Hotel,String> {
}
