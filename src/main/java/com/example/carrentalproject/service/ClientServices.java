package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientServices {

    public List<Client> findAll();

    public Optional<Client> findById(int clientId);

    public int save(SaveClientRequest saveClientRequest);

    public void delete(int clientId);
}
