package com.project.limits_service.controller;
/*
 * @created 30/05/2024 - 22:53
 * @project limits-service
 * @author prashantrajput01
 */

import com.project.limits_service.config.Configuration;
import com.project.limits_service.dto.response.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;
    @GetMapping("/limits")
    public Limits limits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
