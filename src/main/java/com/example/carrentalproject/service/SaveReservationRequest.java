package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveReservationRequest {
    private int id;


    private String clientName;
    private String clientEmail;
    private String phoneNumber;

    private int carId;

    private String pickUpLocation;

    private Date pickUpDate;

    private String pickUpTime;

    private int finalPrice;

    private String comment;

    private class WebDataBinder {
    }
}

