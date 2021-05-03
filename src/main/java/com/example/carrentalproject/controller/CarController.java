package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.service.impl.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("car")
    public Car addcar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("cars/{carId}")
    public ResponseEntity<?> getCarById(@PathVariable Integer carId) {
        return carService.getCarById(carId);
    }

    @PutMapping("car/update/{carId}")
    public ResponseEntity<?> updateCar(@PathVariable Integer carId, @Valid @RequestBody Car carRequest) {
        return carService.updateCar(carId, carRequest);
    }

    @DeleteMapping("cars/delete/{carId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer carId) {
        return carService.deleteCar(carId);
    }
}
