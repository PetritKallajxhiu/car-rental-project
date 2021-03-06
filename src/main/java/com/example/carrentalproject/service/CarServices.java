package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarServices {


    public List<Car> findAll();

    public List<Car> search(String name);

    public Optional<Car> findById(int carId);

    public int save(SaveCarRequest saveCarRequest);

    public void delete(int carId);

    public List<Car> featured();
}
