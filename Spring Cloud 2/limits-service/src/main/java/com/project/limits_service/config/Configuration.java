package com.project.limits_service.config;/*
 * @created 30/05/2024 - 23:17
 * @project limits-service
 * @author prashantrajput01

 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
@Data
public class Configuration {
    private int minimum;
    private int maximum;
}
