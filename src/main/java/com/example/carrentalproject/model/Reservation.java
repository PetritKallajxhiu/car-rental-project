package com.example.carrentalproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String pickUpLocation;
    private Date pickUpDate;
    private Time pickUpTime;
    private int finalPrice;
    private String comment;

    private Date createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carId", insertable = false, updatable = false)
    private Car car;
    private int carId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;
    private int clientId;
}
