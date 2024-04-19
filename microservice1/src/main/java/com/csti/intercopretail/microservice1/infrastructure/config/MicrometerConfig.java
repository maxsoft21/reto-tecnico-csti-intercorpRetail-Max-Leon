package com.csti.intercopretail.microservice1.infrastructure.config;

import com.csti.intercopretail.microservice1.domain.service.MicrometerServiceImpl;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {
    @Bean
    public MicrometerServiceImpl someService(MeterRegistry meterRegistry) {
        return new MicrometerServiceImpl(meterRegistry);
    }
}
