package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Car;
import com.example.carrentalproject.service.SaveCarRequest;
import com.example.carrentalproject.service.impl.CarServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    //   @Autowired Nuk keshillohet te behet me autowired por me konstuktor
    private CarServiceImpl carServiceImpl;

    public CarController(final CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @PostMapping
    public int addcar(@RequestBody SaveCarRequest request) {
        return carServiceImpl.save(request);
    }

    @GetMapping
    public List<Car> getCars() {
        return carServiceImpl.findAll();
    }

    @GetMapping("/{carId}")
    public Optional<Car> findById(@PathVariable int carId) {
        return carServiceImpl.findById(carId);
    }

    @PutMapping
    public int updateCar(@Valid @RequestBody SaveCarRequest requestCar) {
        return carServiceImpl.save(requestCar);
    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable int carId) {
        carServiceImpl.delete(carId);
    }
}
