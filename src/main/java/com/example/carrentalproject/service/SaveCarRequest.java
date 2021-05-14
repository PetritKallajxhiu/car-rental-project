package com.example.carrentalproject.service;

import com.example.carrentalproject.util.FuelType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
public class SaveCarRequest {

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

    private int brandId;

}
