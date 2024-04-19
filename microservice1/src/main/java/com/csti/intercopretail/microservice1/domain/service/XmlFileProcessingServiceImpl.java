package com.csti.intercopretail.microservice1.domain.service;

import com.csti.intercopretail.microservice1.application.MicrometerService;
import com.csti.intercopretail.microservice1.application.XmlFileProcessingService;
import com.csti.intercopretail.microservice1.domain.entity.Root;
import com.csti.intercopretail.microservice1.domain.repository.RootRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@AllArgsConstructor
public class XmlFileProcessingServiceImpl implements XmlFileProcessingService {

    private XmlProcessorServiceImpl xmlProcessorService;

    private KafkaProducerServiceImpl kafkaProducerService;

    private RootRepository rootRepository;

    private MicrometerService micrometerService;

    @Value("${kafka.topic.name}")
    private String topicName;

    public void processFilesFromDirectory(String directoryPath) {
        log.info("Iniciando el procesamiento de archivos en el directorio: {}", directoryPath);
        File dir = new File(directoryPath);

        if (!dir.exists() || !dir.isDirectory()) {
            log.info("El directorio especificado no existe o no se puede leer.");
            return;
        }

        File[] directoryListing = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".xml"));

        if (directoryListing == null) {
            log.info("No se encontraron archivos XML en el directorio: {}", directoryPath);
            return;
        }

        for (File child : directoryListing) {
            try {
                processXmlFile(child);
            } catch (IOException | JAXBException e) {
                log.error("Error al procesar el archivo {}: {}", child.getName(), e.getMessage());
            }
        }

        log.info("Finalizado el procesamiento de archivos en el directorio: {}", directoryPath);
    }

    private void processXmlFile(File file) throws IOException, JAXBException {
        Path filePath = file.toPath();
        BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
        LocalDateTime lastModifiedTime = LocalDateTime.ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault());

        if (lastModifiedTime.isBefore(LocalDateTime.now().minusMinutes(3))) {
            String xmlContent = new String(Files.readAllBytes(filePath));
            Root root = xmlProcessorService.processXml(xmlContent);
            root.setLastUpdate("MICROSERVICES_PROCESS_01_" + getCurrentDateTime());
            rootRepository.save(root);
            String jsonContent = convertRootToJson(root);
            kafkaProducerService.send(topicName, jsonContent);
            micrometerService.handleRequest();
            log.info("Archivo {} procesado exitosamente.", file.getName());
        } else {
            log.info("Archivo {} modificado recientemente, se omitirá.", file.getName());
        }
    }

    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private String convertRootToJson(Root root) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(root);
    }
}
