package com.csti.intercopretail.microservice3.domain.service.upd;

import com.csti.intercopretail.microservice3.application.RootServiceUpd;
import com.csti.intercopretail.microservice3.domain.entity.RootUpdated;
import com.csti.intercopretail.microservice3.domain.repository.RootRepositoryUpd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RootServiceImplUpd implements RootServiceUpd {

    @Autowired
    private RootRepositoryUpd rootRepositoryUpd;
    @Override
    public List<RootUpdated> getAllMessages() {
        return rootRepositoryUpd.findAll();
    }
}
