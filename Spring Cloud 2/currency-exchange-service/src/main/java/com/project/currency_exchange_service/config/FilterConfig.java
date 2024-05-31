package com.project.currency_exchange_service.config;/*
 * @created 01/06/2024 - 00:01
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<GatewayFilter> gatewayFilter() {
        FilterRegistrationBean<GatewayFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new GatewayFilter());
        registrationBean.addUrlPatterns("/currency-convert/*");

        return registrationBean;
    }
}

