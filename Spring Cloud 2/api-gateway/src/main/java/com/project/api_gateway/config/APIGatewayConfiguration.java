package com.project.api_gateway.config;/*
 * @created 01/06/2024 - 00:12
 * @project api-gateway
 * @author prashantrajput01

 */

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class APIGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){
        Function<PredicateSpec, Buildable<Route>> routeFunction = route-> route.path("/get").uri("http://httpbin.org:80");
        //Function<PredicateSpec, Buildable<Route>> currencyExchange = currencyConversionRoute->currencyConversionRoute.path("/currency-exchange/**").uri("lb://currency-exchange-service");
        Function<PredicateSpec, Buildable<Route>> currencyConversion = currencyConversionRoute->currencyConversionRoute.path("/currency-convert/**").uri("lb://currency-conversion-service");
        return  routeLocatorBuilder.routes()
                .route(routeFunction)
                //.route(currencyExchange)
                .route(currencyConversion)

                .build();
    }
}
