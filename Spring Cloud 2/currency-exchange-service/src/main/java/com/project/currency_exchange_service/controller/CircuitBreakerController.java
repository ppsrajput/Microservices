package com.project.currency_exchange_service.controller;/*
 * @created 07/06/2024 - 22:08
 * @project currency-exchange-service
 * @author prashantrajput01

 */

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    @Retry(name = "sample-api",fallbackMethod = "fallback")
    public String sample(){
        log.info("Request-Request-Request-Request");
        throw new RuntimeException();
       // return "Sample API";
    }

    public String fallback(Throwable throwable) {
        return "Fallback-response";
    }
}
