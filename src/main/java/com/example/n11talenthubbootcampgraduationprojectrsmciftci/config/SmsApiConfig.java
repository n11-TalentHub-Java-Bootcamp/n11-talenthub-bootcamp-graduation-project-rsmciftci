package com.example.n11talenthubbootcampgraduationprojectrsmciftci.config;

import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.SmsApiDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:smsapi.properties")
@Configuration
public class SmsApiConfig {

    @Bean
    SmsApiDataSource smsApiDataSource(
            @Value("${smsapi.username}") String username,
            @Value("${smsapi.password}") String password
    ){
        SmsApiDataSource smsApiDataSource = new SmsApiDataSource();
        smsApiDataSource.setUsername(username);
        smsApiDataSource.setPassword(password);

        return smsApiDataSource;

    }


}
