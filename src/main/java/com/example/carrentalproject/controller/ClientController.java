package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.service.SaveClientRequest;
import com.example.carrentalproject.service.impl.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    ClientService clientService;

    private ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public int addClient(@RequestBody SaveClientRequest request) {
        return clientService.save(request);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @GetMapping("/{clientId}")
    public Optional<Client> findById(@PathVariable int clientId) {
        return clientService.findById(clientId);
    }

    @PutMapping
    public int updateClient(@Valid @RequestBody SaveClientRequest request) {
        return clientService.save(request);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable int clientId) {
        clientService.delete(clientId);
    }


}
