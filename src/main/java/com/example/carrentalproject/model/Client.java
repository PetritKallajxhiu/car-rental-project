package com.example.carrentalproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId")
    private int id;

    private String name;
    private String email;
    private String phoneNumber;

}
