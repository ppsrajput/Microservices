package com.ptech.rating.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * @project RatingService
 * @auther Prash on 08-04-2023
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ratings")
public class Rating {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Integer id;
 private String userId;
 private String hotelId;
 private int rating;
 private String feedback;
}
