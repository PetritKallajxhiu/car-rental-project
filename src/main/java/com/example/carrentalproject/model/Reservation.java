package com.example.carrentalproject.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservationId")
    private int id;

    private String pickUpLocation;
    private Date pickUpDate;
    private Time pickUpTime;
    private int finalPrice;
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_carId", insertable = false, updatable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_clientId", insertable = false, updatable = false)
    private Client client;

}
