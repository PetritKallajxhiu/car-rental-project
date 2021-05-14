package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Reservation;
import com.example.carrentalproject.service.ReservationServices;
import com.example.carrentalproject.service.SaveReservationRequest;
import com.example.carrentalproject.service.impl.ReservationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private ReservationServices reservationService;

    public ReservationController(ReservationServiceImpl reservationServiceImpl) {
        this.reservationService = reservationServiceImpl;
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

    @PutMapping
    public int update(@PathVariable SaveReservationRequest request) {
        return reservationService.save(request);
    }

    @DeleteMapping("/{reservationId}")
    public void delete(@PathVariable int reservationId) {
        reservationService.delete(reservationId);
    }
}
