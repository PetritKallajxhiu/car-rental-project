package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarServices {

    List<Car> findAll();

    Optional<Car> findById(int carId);

    int save(SaveCarRequest saveCarRequest);

    void delete(int carId);

    List<Car> featured();
}
