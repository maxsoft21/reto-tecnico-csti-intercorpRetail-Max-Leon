package com.csti.intercopretail.microservice2.application;

import com.csti.intercopretail.microservice2.domain.entity.RootUpdated;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface RootService {

    void updateAndSaveRoot(String message) throws JsonProcessingException;
}
