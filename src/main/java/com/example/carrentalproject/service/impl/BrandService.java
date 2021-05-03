package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.repository.BrandRepository;
import com.example.carrentalproject.service.BrandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandService implements BrandServices {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getBrandById(Integer brandId) {
        Brand brand = brandRepository.findOne(brandId);
        if (brand != null) {
            Map<String, Brand> result = new HashMap<String, Brand>();
            result.put("Brand: ", brand);
            return new ResponseEntity<Map<String, Brand>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Not found Brand with id: ", brandId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> updateBrand(Integer brandId, Brand brandRequest) {
        Brand brand = brandRepository.findById(brandId).get();
        if (brand != null) {
            brand.setName(brandRequest.getName());
            brandRepository.save(brand);

            Map<String, Brand> result = new HashMap<String, Brand>();
            result.put("Brand updated ", brand);
            return new ResponseEntity<Map<String, Brand>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Not found Brand with id ", brandId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteBrand(Integer brandId) {
        Brand brand = brandRepository.getById(brandId);
        if (brand != null) {
            brandRepository.delete(brand);
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Successfully deleted Brand with Id: ", brandId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.OK);
        } else {
            Map<String, Integer> result = new HashMap<String, Integer>();
            result.put("Not found Brand with Id: ", brandId);
            return new ResponseEntity<Map<String, Integer>>(result, HttpStatus.NOT_FOUND);
        }
    }
}
