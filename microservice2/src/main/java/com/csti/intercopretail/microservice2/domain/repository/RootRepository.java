package com.csti.intercopretail.microservice2.domain.repository;

import com.csti.intercopretail.microservice2.domain.entity.RootUpdated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootRepository extends JpaRepository<RootUpdated, Long> {
}
