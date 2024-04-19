package com.csti.intercopretail.microservice1.application;

import com.csti.intercopretail.microservice1.domain.entity.Root;
import jakarta.xml.bind.JAXBException;

public interface XmlProcessorService {
    Root processXml(String xmlContent) throws JAXBException;
}
