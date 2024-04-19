package com.csti.intercopretail.microservice3.domain.service;

import com.csti.intercopretail.microservice3.application.PersonService;
import com.csti.intercopretail.microservice3.domain.entity.Person;
import com.csti.intercopretail.microservice3.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Override
    public List<Person> getAllMessages() {
        return personRepository.findAll();
    }
}
