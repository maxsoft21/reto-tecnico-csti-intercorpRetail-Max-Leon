package com.csti.intercopretail.microservice3.domain.repository;

import com.csti.intercopretail.microservice3.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
