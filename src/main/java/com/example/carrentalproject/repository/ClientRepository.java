package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
