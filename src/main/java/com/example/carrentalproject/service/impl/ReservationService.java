package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Reservation;
import com.example.carrentalproject.repository.ReservationRepository;
import com.example.carrentalproject.service.ReservationServices;
import com.example.carrentalproject.service.SaveReservationRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationServices {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findAllById(int reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public int save(SaveReservationRequest request) {
        var reservation = reservationRepository.findById(request.getId());
        if (reservation.isPresent()) {
            reservation.get().setPickUpTime(request.getPickUpTime());
            reservation.get().setPickUpDate(request.getPickUpDate());
            reservation.get().setPickUpLocation(request.getPickUpLocation());
            reservation.get().setFinalPrice(request.getFinalPrice());
            reservation.get().setComment(request.getComment());
            reservation.get().setCarId(request.getCarId());
            reservation.get().setClientId(request.getClientId());

            reservationRepository.save(reservation.get());
            return reservation.get().getId();
        } else {
            var newReservation = Reservation.builder()
                    .pickUpLocation(request.getPickUpLocation())
                    .pickUpDate(request.getPickUpDate())
                    .pickUpTime(request.getPickUpTime())
                    .finalPrice(request.getFinalPrice())
                    .comment(request.getComment())
                    .clientId(request.getClientId())
                    .carId(request.getCarId())
                    .createdAt(new Date())
                    .build();
            reservationRepository.save(newReservation);
            return newReservation.getId();
        }
    }

    @Override
    public void delete(int reservationId) {
        var reservation = reservationRepository.findById(reservationId).orElseThrow(
                () -> new IllegalArgumentException("Id is invalid"));
        reservationRepository.delete(reservation);
    }
}
