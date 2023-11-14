package com.example.app.Controller;


import com.example.app.Entity.Mail;
import com.example.app.Repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MailController {

    @Autowired
    CustomerRepository customerRepo;

    @RequestMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<Mail>> getAllItems(){
        List<Mail> items =  customerRepo.findAll();
        return new ResponseEntity<List<Mail>>(items, HttpStatus.OK);
    }


}
