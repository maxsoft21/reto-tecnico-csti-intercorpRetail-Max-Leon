package com.csti.intercopretail.microservice2.infrastructure.listener;

import com.csti.intercopretail.microservice2.application.RootService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumerListener {

    private final RootService rootService;

    @KafkaListener(topics = {"topic-microservicio1"}, groupId = "topic-microservicio1-group-id")
    @Transactional
    public void listen(String message) {
        log.info("Received message: {}", message);
        try {
            rootService.updateAndSaveRoot(message);
            log.info("Root object saved to the database");
        } catch (Exception e) {
            log.error("Error processing message", e);
        }
    }
}

