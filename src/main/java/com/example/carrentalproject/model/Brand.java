package com.example.carrentalproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "brands")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "brandId")
    private int id;

    private String name;
}
