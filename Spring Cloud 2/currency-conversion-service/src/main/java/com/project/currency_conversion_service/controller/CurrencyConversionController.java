package com.project.currency_conversion_service.controller;/*
 * @created 31/05/2024 - 12:11
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import com.project.currency_conversion_service.dto.response.CurrencyConversionDTO;
import com.project.currency_conversion_service.service.CurrencyExchangeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeFeignService exchangeFeignService;
    @GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionDTO currencyConvert(@PathVariable String from, @PathVariable String to, @PathVariable Long quantity){
        CurrencyConversionDTO currencyExchangeDTO = exchangeFeignService.exchangeValue(from, to);
        return new CurrencyConversionDTO(101L,from,to,currencyExchangeDTO.getConversionMultiple(), currencyExchangeDTO.getEnvironment(), quantity, currencyExchangeDTO.getConversionMultiple()*quantity);
    }
}
