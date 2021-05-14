package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Client;
import com.example.carrentalproject.service.SaveClientRequest;
import com.example.carrentalproject.service.impl.ClientServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    ClientServiceImpl clientServiceImpl;

    private ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @PostMapping
    public int addClient(@RequestBody SaveClientRequest request) {
        return clientServiceImpl.save(request);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientServiceImpl.findAll();
    }

    @GetMapping("/{clientId}")
    public Optional<Client> findById(@PathVariable int clientId) {
        return clientServiceImpl.findById(clientId);
    }

    @PutMapping
    public int updateClient(@Valid @RequestBody SaveClientRequest request) {
        return clientServiceImpl.save(request);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable int clientId) {
        clientServiceImpl.delete(clientId);
    }


}
