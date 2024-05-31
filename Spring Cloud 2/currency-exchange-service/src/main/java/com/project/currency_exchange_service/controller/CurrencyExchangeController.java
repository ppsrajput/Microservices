package com.project.currency_exchange_service.controller;/*
 * @created 31/05/2024 - 00:16
 * @project currency-exchange
 * @author prashantrajput01

 */

import com.project.currency_exchange_service.model.ExchangeValue;
import com.project.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue exchangeValue(@PathVariable String from,@PathVariable String to){
        String instance = environment.getProperty("server.port");
        ExchangeValue ex = repository.findByFromAndTo(from, to);
        ex.setEnvironment("Instance - "+ instance);
        return ex;


    }
}