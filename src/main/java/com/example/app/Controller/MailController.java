package com.example.app.Controller;


import com.example.app.Entity.Mail;
import com.example.app.Repo.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    @Autowired
    MailRepository mailRepository;

    @RequestMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<Mail>> getAllItems(){
        List<Mail> items =  mailRepository.findAll();
        return new ResponseEntity<List<Mail>>(items, HttpStatus.OK);
    }


}
