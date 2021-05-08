package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BrandServices {

    public List<Brand> findAll();

    public Optional<Brand> findAllById(int brandId);

    public int save(SaveBrandRequest request);

    public void  delete (int brandId);

}
