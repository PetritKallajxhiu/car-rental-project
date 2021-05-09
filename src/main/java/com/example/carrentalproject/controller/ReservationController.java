package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Reservation;
import com.example.carrentalproject.service.ReservationServices;

import com.example.carrentalproject.service.SaveReservationRequest;

import com.example.carrentalproject.service.impl.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private ReservationServices reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public int create(@RequestBody SaveReservationRequest request) {
        return reservationService.save(request);
    }

    @GetMapping
    public List<Reservation> getReservation() {
        return reservationService.findAll();
    }

    @GetMapping("/{reservationId}")
    public Optional<Reservation> getReservationById(@PathVariable Integer reservationId) {
        return reservationService.findAllById(reservationId);
    }

    @PutMapping("/{reservationId}")
    public int update(@PathVariable SaveReservationRequest request) {
        return reservationService.save(request);
    }

    @DeleteMapping("/{reservationId}")
    public void delete(@PathVariable int reservationId) {
        reservationService.delete(reservationId);
    }


}
