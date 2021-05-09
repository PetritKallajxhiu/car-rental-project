package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationServices {

    public List<Reservation> findAll();

    public Optional<Reservation> findAllById(int reservationId);

    public int save(SaveReservationRequest  request);

    public void  delete (int reservationId);
}
