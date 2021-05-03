package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Car;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarServices {
    public Car addCar(Car car);

    public List<Car> getCars();

    public ResponseEntity<?> getCarById(Integer carId);

    public ResponseEntity<?> updateCar(Integer carId, Car carRequest);

    public ResponseEntity<?> deleteCar(Integer carId);
}
