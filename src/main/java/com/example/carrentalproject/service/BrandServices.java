package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Brand;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BrandServices {
    public Brand addBrand(Brand brand);

    public List<Brand> getBrands();

    public ResponseEntity<?> getBrandById(Integer brandId);

    public ResponseEntity<?> updateBrand(Integer brandId, Brand brandRequest);

    public ResponseEntity<?> deleteBrand(Integer brandId);

}
