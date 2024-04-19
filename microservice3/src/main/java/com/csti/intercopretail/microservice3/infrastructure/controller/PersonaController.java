package com.csti.intercopretail.microservice3.infrastructure.controller;

import com.csti.intercopretail.microservice3.application.*;
import com.csti.intercopretail.microservice3.domain.entity.Person;
import com.csti.intercopretail.microservice3.domain.entity.PersonUpdated;
import com.csti.intercopretail.microservice3.domain.entity.Root;
import com.csti.intercopretail.microservice3.domain.entity.RootUpdated;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonaController {

    private PersonService service;

    private PersonServiceUpd serviceupd;

    private RootService rootService;

    private RootServiceUpd rootServiceUpd;

    private MicrometerService micrometerService;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPerson() {
        List<Person> persons = service.getAllMessages();
        if (persons.isEmpty()) {
            micrometerService.handleRequest();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(persons);
        }
        return ResponseEntity.ok(persons);
    }

    @GetMapping("/person-upd")
    public ResponseEntity<List<PersonUpdated>> getPersonUpd() {
        List<PersonUpdated> data = serviceupd.getAllMessages();
        if (data.isEmpty()) {
            micrometerService.handleRequest();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(data);
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/root")
    public ResponseEntity<List<Root>> getRoot() {
        List<Root> data = rootService.getAllMessages();
        if (data.isEmpty()) {
            micrometerService.handleRequest();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(data);
        }
        return ResponseEntity.ok(data);
    }

    @GetMapping("/root-upd")
    public ResponseEntity<List<RootUpdated>> getRootUpd() {
        List<RootUpdated> data = rootServiceUpd.getAllMessages();
        if (data.isEmpty()) {
            micrometerService.handleRequest();
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(data);
        }
        return ResponseEntity.ok(data);
    }
}
