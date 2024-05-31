package com.project.currency_conversion_service.config;/*
 * @created 31/05/2024 - 12:26
 * @project currency-conversion-service
 * @author prashantrajput01

 */

import feign.codec.Encoder;
import feign.form.FormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class CustomFeignClientConfiguration {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignFormEncoder(){
        return new FormEncoder(new SpringEncoder(this.messageConverters));
    }
}
