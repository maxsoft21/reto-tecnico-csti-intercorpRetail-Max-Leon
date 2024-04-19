package com.csti.intercopretail.microservice1.application;

public interface KafkaProducerService {
    void send(String topic, String message);
}
