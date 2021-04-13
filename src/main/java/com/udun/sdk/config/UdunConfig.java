package com.udun.sdk.config;

import com.udun.sdk.client.UdunClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UdunConfig {
    @Bean
    UdunClient udunClient(UdunProperties udunProperties) {
        return new UdunClient(udunProperties.getGateway(), udunProperties.getMerchantId(), udunProperties.getMerchantKey(), udunProperties.getCallUrl());
    }
}
