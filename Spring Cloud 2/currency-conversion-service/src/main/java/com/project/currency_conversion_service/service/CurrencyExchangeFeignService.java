package com.project.currency_conversion_service.service;/*
 * @created 31/05/2024 - 12:17
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import com.project.currency_conversion_service.config.CustomFeignClientConfiguration;
import com.project.currency_conversion_service.dto.response.CurrencyConversionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service",url = "http://localhost:8200",configuration = CustomFeignClientConfiguration.class)
public interface CurrencyExchangeFeignService {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionDTO exchangeValue(@PathVariable String from, @PathVariable String to);
}
