package com.example.resotest.service;


import com.example.resotest.model.Partner;

import java.util.List;

public interface PartnerService {

    Partner save(Partner partner);

    List<Partner> findAll();

    void deleteById(Long id);

    String getEmailById(Long id);
}
