package com.project.currency_conversion_service.dto.response;/*
 * @created 31/05/2024 - 12:13
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionDTO {
    private Long id;
    private String from;
    private String to;
    private Double conversionMultiple;
    private String environment;
    private Long quantity;
    private Double totalCalculatedAmount;

}
