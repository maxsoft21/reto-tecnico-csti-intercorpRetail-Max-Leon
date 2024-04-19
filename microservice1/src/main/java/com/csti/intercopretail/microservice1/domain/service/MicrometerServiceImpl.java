package com.csti.intercopretail.microservice1.domain.service;

import com.csti.intercopretail.microservice1.application.MicrometerService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

@Service
public class MicrometerServiceImpl implements MicrometerService {

    private final Counter requestCounter;

    public MicrometerServiceImpl(MeterRegistry meterRegistry) {
        this.requestCounter = meterRegistry.counter("requests");
    }

    public void handleRequest() {
        requestCounter.increment();
    }
}