package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.service.ClientServices;
import com.example.carrentalproject.service.SaveClientRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private ClientServices clientServices;

    private ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @PostMapping
    public int addClient(@RequestBody SaveClientRequest request) {
        return clientServices.save(request);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientServices.findAll();
    }

    @GetMapping("/{clientId}")
    public Optional<Client> findById(@PathVariable int clientId) {
        return clientServices.findById(clientId);
    }

    @PutMapping
    public int updateClient(@Valid @RequestBody SaveClientRequest request) {
        return clientServices.save(request);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable int clientId) {
        clientServices.delete(clientId);
    }


}
