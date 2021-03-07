package com.example.resotest.controller;

import com.example.resotest.model.Partner;
import com.example.resotest.service.MailSender;
import com.example.resotest.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/")
public class PartnerController {

    @Autowired
    PartnerService partnerService;


    @GetMapping("/")
    public String toIndex() {
        return "index.html";
    }


    @PostMapping("/create")
    public String create(@RequestParam String name) {
        Partner partner = new Partner();
        partner.setName(name);
        partner.setActive(true);
        partnerService.save(partner);
        return "index.html";
    }

}
