package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars WHERE featured = true", nativeQuery = true)
    List<Car> findAllFeatured();


public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT c FROM Car c WHERE c.name = :name")
    List<Car> search(@Param("name") String name);

}
