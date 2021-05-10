package com.example.carrentalproject.service;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
public class SaveReservationRequest {
    private int id;

    private String pickUpLocation;
    private Date pickUpDate;
    private Time pickUpTime;
    private int finalPrice;
    private String comment;
    private Date createdAt;
    private int carId;
    private int clientId;
}


