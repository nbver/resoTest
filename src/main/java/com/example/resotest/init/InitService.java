package com.example.resotest.init;

import com.example.resotest.model.Partner;
import com.example.resotest.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class InitService {

    @Autowired
    PartnerService partnerService;
    @Autowired
    PasswordEncoder passwordEncoder;

    private void init() {
        initPartners();
    }

    private void initPartners() {
        Partner partner1 = new Partner();
        partner1.setEmail("buharaman@gmail.com");
        partner1.setPassword(passwordEncoder.encode("1"));
        partner1.setActive(true);
        partnerService.save(partner1);
        Partner partner2 = new Partner();
        partner2.setEmail("rakhmatullin_ta@inbox.ru");
        partner2.setPassword(passwordEncoder.encode("2"));
        partner2.setActive(true);
        partnerService.save(partner2);
    }

}
