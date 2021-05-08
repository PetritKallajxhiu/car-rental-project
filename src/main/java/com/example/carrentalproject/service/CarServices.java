package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CarServices {

    public List<Car> findAll();

    public Optional<Car> findById(Integer carId);

    public int save(SaveCarRequest saveCarRequest);

    public void deleteCar(int carId);
}
