package com.csti.intercopretail.microservice3.domain.service;

import com.csti.intercopretail.microservice3.application.RootService;
import com.csti.intercopretail.microservice3.domain.entity.Root;
import com.csti.intercopretail.microservice3.domain.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootRepository rootRepository;
    @Override
    public List<Root> getAllMessages() {
        return rootRepository.findAll();
    }
}
