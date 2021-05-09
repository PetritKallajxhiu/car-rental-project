package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.service.SaveCarRequest;
import com.example.carrentalproject.service.impl.CarService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    //   @Autowired Nuk keshillohet te behet me autowired por me konstuktor
    private CarService carService;

    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public int addcar(@RequestBody SaveCarRequest request) {
        return carService.save(request);
    }

    @GetMapping
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/{carId}")
    public Optional<Car> findById(@PathVariable int carId) {
        return carService.findById(carId);
    }

    @PutMapping
    public int updateCar(@Valid @RequestBody SaveCarRequest requestCar) {
        return carService.save(requestCar);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable int carId) {
        carService.delete(carId);
    }
}
