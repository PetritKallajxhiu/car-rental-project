package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.repository.ClientRepository;
import com.example.carrentalproject.service.ClientServices;
import com.example.carrentalproject.service.SaveClientRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ClientServices {
    ClientRepository clientRepository;

    private ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(int clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public int save(SaveClientRequest request) {
        var client = clientRepository.findById(request.getId());
        if (client.isPresent()) {
            client.get().setName(request.getName());
            client.get().setEmail(request.getEmail());
            client.get().setPhoneNumber(request.getPhoneNumber());
            clientRepository.save(client.get());
            return client.get().getId();
        } else {
            var newClient = Client.builder()
                    .name(request.getName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .createdAt(new Date())
                    .build();
            clientRepository.save(newClient);
            return newClient.getId();
        }
    }

    @Override
    public void delete(int clientId) {
        var client = clientRepository.findById(clientId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        clientRepository.delete(client);
    }
}
