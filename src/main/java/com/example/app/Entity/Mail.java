package com.example.app.Entity;

import javax.persistence.*;

@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String mail;
}