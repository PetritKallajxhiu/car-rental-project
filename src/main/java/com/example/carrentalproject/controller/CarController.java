package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.SaveCarRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    //   @Autowired Nuk keshillohet te behet me autowired por me konstuktor
    private CarServices carServices;

    public CarController(final CarServices carServices) {
        this.carServices = carServices;
    }

    @PostMapping
    public int addcar(@RequestBody SaveCarRequest request) {
        return carServices.save(request);
    }

    @GetMapping
    public List<Car> getCars() {
        return carServices.findAll();
    }

    @GetMapping("/{carId}")
    public Optional<Car> findById(@PathVariable int carId) {
        return carServices.findById(carId);
    }

    @PutMapping
    public int updateCar(@Valid @RequestBody SaveCarRequest requestCar) {
        return carServices.save(requestCar);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable int carId) {
        carServices.delete(carId);
    }

}
