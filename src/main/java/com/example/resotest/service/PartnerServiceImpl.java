package com.example.resotest.service;

import com.example.resotest.dao.PartnerRepository;
import com.example.resotest.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartnerServiceImpl implements PartnerService{

    @Autowired
    PartnerRepository repository;

    @Override
    public Partner save(Partner partner) {
        return repository.save(partner);
    }

    @Override
    public List<Partner> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public String getEmailById(Long id) {
        return repository.findEmailById(id);
    }
}
