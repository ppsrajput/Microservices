package com.project.currency_exchange_service.model;
/*
 * @created 31/05/2024 - 00:00
 * @project currency-exchange
 * @author prashantrajput01

 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeValue {
    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "conversion_multiple")
    private Double conversionMultiple;
    @Transient
    private String environment;
}