package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.model.Reservation;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class SaveReservationRequest {
    private int id;

    private Client client;
    private String clientName;
    private String clientEmail;
    private String phoneNumber;

    private int carId;

    private Reservation reservation;
    private String pickUpLocation;

    private Date pickUpDate;

    private String pickUpTime;

    private int finalPrice;
    private String comment;
}

