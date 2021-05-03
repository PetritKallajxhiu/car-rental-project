package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars WHERE car_id = :id", nativeQuery = true)
    Car findOne(@Param("id") Integer id);

}
