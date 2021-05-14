package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.model.Reservation;
import com.example.carrentalproject.repository.ClientRepository;
import com.example.carrentalproject.repository.ReservationRepository;
import com.example.carrentalproject.service.ReservationServices;
import com.example.carrentalproject.service.SaveReservationRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationServices {

    private ReservationRepository reservationRepository;
    private ClientRepository clientRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ClientRepository clientRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
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
    @Transactional
    public int save(SaveReservationRequest request) {
        Client newClient = new Client();
        newClient.setName(request.getClientName());
        newClient.setEmail(request.getClientEmail());
        newClient.setPhoneNumber(request.getPhoneNumber());
        newClient.setCreatedAt(new Date());
        clientRepository.save(newClient);

        Reservation newReservation = new Reservation();
        newReservation.setPickUpLocation(request.getPickUpLocation());
        newReservation.setPickUpDate(request.getPickUpDate());
        newReservation.setPickUpTime(request.getPickUpTime());
        newReservation.setFinalPrice(request.getFinalPrice());
        newReservation.setComment(request.getComment());
        newReservation.setClientId(newClient.getId());
        newReservation.setClient(newClient);
        newReservation.setCarId(request.getCarId());
        newReservation.setCreatedAt(new Date());
        reservationRepository.save(newReservation);

        return newReservation.getId();
    }

    @Override
    public void delete(int reservationId) {
        var reservation = reservationRepository.findById(reservationId).orElseThrow(
                () -> new IllegalArgumentException("Id is invalid"));
        reservationRepository.delete(reservation);
    }
}
