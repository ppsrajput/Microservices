package com.project.limits_service.dto.response;/*
 * @created 30/05/2024 - 22:54
 * @project limits-service
 * @author prashantrajput01

 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Limits {
    private int minimum;
    private int maximum;

}
