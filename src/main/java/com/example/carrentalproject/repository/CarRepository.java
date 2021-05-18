package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars WHERE featured = true", nativeQuery = true)
    List<Car> findAllFeatured();
}
