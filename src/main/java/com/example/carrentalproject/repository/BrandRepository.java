package com.example.carrentalproject.repository;

import com.example.carrentalproject.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

    @Query(value = "SELECT * FROM brands WHERE brand_id = :id", nativeQuery = true)
    Brand findOne(@Param("id") Integer id);
}
