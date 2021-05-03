package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.repository.CarRepository;
import com.example.carrentalproject.service.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService implements CarServices {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getCarById(Integer carId) {
        Car car = carRepository.findOne(carId);
        if (car != null) {
            Map<String, Car> result = new HashMap<String, Car>();
            result.put("Car: ", car);
            return new ResponseEntity<Map<String, Car>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("not found User with Id: ", carId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> updateCar(Integer carId, Car carRequest) {
        Car car = carRepository.findById(carId).get();
        if (car != null) {
            car.setName(carRequest.getName());
            car.setBrand(carRequest.getBrand());
            car.setDoors(carRequest.getDoors());
            car.setEngine(carRequest.getEngine());
            car.setFuelType(carRequest.getFuelType());
            car.setLocation(carRequest.getLocation());
            car.setPassengers(carRequest.getPassengers());
            car.setPhoto(carRequest.getPhoto());
            car.setPrice(carRequest.getPrice());
            car.setFeatured(carRequest.isFeatured());

            carRepository.save(car);

            Map<String, Car> result = new HashMap<String, Car>();
            result.put("User Updated ", car);
            return new ResponseEntity<Map<String, Car>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("not found User with Id: ", carId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteCar(Integer carId) {
        Car car = carRepository.findOne(carId);
        if (car != null) {
            carRepository.delete(car);

            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Successfully deleted user with Id: ", carId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Not found User with Id: ", carId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }
}
