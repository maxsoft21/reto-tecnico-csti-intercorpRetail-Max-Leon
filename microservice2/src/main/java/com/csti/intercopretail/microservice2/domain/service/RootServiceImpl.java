package com.csti.intercopretail.microservice2.domain.service;

import com.csti.intercopretail.microservice2.application.MicrometerService;
import com.csti.intercopretail.microservice2.application.RootService;
import com.csti.intercopretail.microservice2.domain.entity.RootUpdated;
import com.csti.intercopretail.microservice2.domain.repository.RootRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;


@Service
@AllArgsConstructor
public class RootServiceImpl implements RootService {

    private final RootRepository rootRepository;
    private final ObjectMapper objectMapper;
    private final MicrometerService micrometerService;
    private static final int RANDOM_TEXT_LENGTH = 10;
    @Override
    public void updateAndSaveRoot(String message) throws JsonProcessingException {
        RootUpdated root = objectMapper.readValue(message, RootUpdated.class);
        if (root.getPerson() != null) {
            root.setRegEx(generateRandomText());
        }
        root.setLastModified("MICROSERVICES_PROCESS_02_" + getCurrentDateTime());
        rootRepository.save(root);
        micrometerService.handleRequest();
    }

    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public static String generateRandomText() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[RANDOM_TEXT_LENGTH];
        secureRandom.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }

    public static void main(String[] args) {
        String randomText = generateRandomText();
        System.out.println("Random Text: " + randomText);
    }
}
