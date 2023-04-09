package com.ptech.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @project UserService
 * @auther Prash on 09-04-2023
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
 private String id;
 private String name;
 private String location;
 private String about;
}
