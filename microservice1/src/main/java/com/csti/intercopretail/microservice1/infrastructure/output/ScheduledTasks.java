package com.csti.intercopretail.microservice1.infrastructure.output;

import com.csti.intercopretail.microservice1.application.XmlFileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {

    @Autowired
    private XmlFileProcessingService xmlFileProcessingService;

    @Value("${spring.application.rutaArchivo}")
    private String DIRECTORY_PATH;

    @Scheduled(fixedDelay = 180000)
    public void processFilesPeriodically() {
        xmlFileProcessingService.processFilesFromDirectory(DIRECTORY_PATH);
    }
}
