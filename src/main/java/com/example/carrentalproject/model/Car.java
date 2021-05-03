package com.example.carrentalproject.model;

import com.example.carrentalproject.util.FuelType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "carId")
    private int id;

    private String name;
    private int passengers;
    private int doors;
    private String engine;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private String photo;
    private int price;
    private String location;
    private boolean featured;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_brandId",insertable = false,updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Brand brand;
}
