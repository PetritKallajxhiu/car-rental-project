package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.repository.CarRepository;
import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.SaveCarRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarService implements CarServices {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(int carId) {
        return carRepository.findById(carId);
    }

    @Override
    public int save(SaveCarRequest request) {
        var car = carRepository.findById(request.getId());
        if (car.isPresent()) {
            car.get().setName(request.getName());
            car.get().setBrandId(request.getBrandId());
            car.get().setLocation(request.getLocation());
            car.get().setDoors(request.getDoors());
            car.get().setFuelType(request.getFuelType());
            car.get().setFeatured(request.isFeatured());
            car.get().setPhoto(request.getPhoto());
            car.get().setEngine(request.getEngine());
            car.get().setPhoto(request.getPhoto());
            car.get().setPrice(request.getPrice());
            car.get().setPassengers(request.getPassengers());
            carRepository.save(car.get());
            return car.get().getId();
        } else {
            var newCar = Car.builder()
                    .name(request.getName())
                    .brandId(request.getBrandId())
                    .passengers(request.getPassengers())
                    .doors(request.getDoors())
                    .engine(request.getEngine())
                    .fuelType(request.getFuelType())
                    .photo(request.getPhoto())
                    .location(request.getLocation())
                    .price(request.getPrice())
                    .featured(request.isFeatured())
                    .createdAt(new Date())
                    .build();
            carRepository.save(newCar);
            return newCar.getId();
        }
    }

    @Override
    public void delete(int carId) {
        var car = carRepository.findById(carId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        carRepository.delete(car);
    }
}
