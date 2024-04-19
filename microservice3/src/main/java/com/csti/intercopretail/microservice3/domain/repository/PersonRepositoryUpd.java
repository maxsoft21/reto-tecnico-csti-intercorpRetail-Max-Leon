package com.csti.intercopretail.microservice3.domain.repository;

import com.csti.intercopretail.microservice3.domain.entity.PersonUpdated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryUpd extends JpaRepository<PersonUpdated, Long> {
}
