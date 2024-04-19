package com.csti.intercopretail.microservice3.domain.service.upd;

import com.csti.intercopretail.microservice3.application.PersonServiceUpd;
import com.csti.intercopretail.microservice3.domain.entity.PersonUpdated;
import com.csti.intercopretail.microservice3.domain.repository.PersonRepositoryUpd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplUpd implements PersonServiceUpd {

    @Autowired
    private PersonRepositoryUpd personRepositoryUpd;
    @Override
    public List<PersonUpdated> getAllMessages() {
        return personRepositoryUpd.findAll();
    }
}
