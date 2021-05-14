package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.service.SaveBrandRequest;
import com.example.carrentalproject.service.impl.BrandServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private BrandServiceImpl brandServiceImpl;

    public BrandController(BrandServiceImpl brandServiceImpl) {
        this.brandServiceImpl = brandServiceImpl;
    }

    @PostMapping
    public int create(@RequestBody SaveBrandRequest request) {
        return brandServiceImpl.save(request);
    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandServiceImpl.findAll();
    }

    @GetMapping("/{brandId}")
    public Optional<Brand> getBrandById(@PathVariable Integer brandId) {
        return brandServiceImpl.findAllById(brandId);
    }

    @PutMapping
    public int update(@PathVariable SaveBrandRequest request) {
        return brandServiceImpl.save(request);
    }

    @DeleteMapping("/{brandId}")
    public void delete(@PathVariable int brandId) {
        brandServiceImpl.delete(brandId);
    }
}
