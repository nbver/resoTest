package com.example.resotest.rest;

import com.example.resotest.model.Partner;
import com.example.resotest.service.MailSender;
import com.example.resotest.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class PartnerRestController {

    @Autowired
    PartnerService partnerService;

    @Autowired
    MailSender mailSender;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Partner>> getAllPartners() {
        List<Partner> partnerList = partnerService.findAll();
        return new ResponseEntity<>(partnerList, HttpStatus.OK);
    }

    //На вход ожидаются все поля партнера, кроме id.
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePartner(@RequestParam Partner partner) {
        List<Partner> partnerList = partnerService.findAll();
        return new ResponseEntity<>(partnerList, HttpStatus.OK);
    }

    //id удаляемого партнера ожидается в URL запроса
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePartner(@PathVariable Long id) {
        partnerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //id партнера ожидается в URL запроса
    @RequestMapping(value = "/send/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendCode(@PathVariable Long id) {
        String email = partnerService.getEmailById(id);
        int code = new Random().nextInt(9999);
        mailSender.send(email, "code", "" + code);
        return new ResponseEntity<>("Sent code to " + email, HttpStatus.OK);
    }


}
