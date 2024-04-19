package com.csti.intercopretail.microservice1.domain.service;

import com.csti.intercopretail.microservice1.application.XmlProcessorService;
import com.csti.intercopretail.microservice1.domain.entity.Root;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.StringReader;

@Service
public class XmlProcessorServiceImpl implements XmlProcessorService {

    public Root processXml(String xmlContent) throws JAXBException {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlContent);
            return (Root) unmarshaller.unmarshal(reader);
    }


}