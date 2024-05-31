package com.project.currency_exchange_service.repository;/*
 * @created 31/05/2024 - 00:18
 * @project currency-exchange
 * @author prashantrajput01

 */

import com.project.currency_exchange_service.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findByFromAndTo(String from,String to);
}