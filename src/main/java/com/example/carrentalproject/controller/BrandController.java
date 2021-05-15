package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.service.BrandServices;
import com.example.carrentalproject.service.SaveBrandRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private BrandServices brandServices;

    public BrandController(BrandServices brandServices) {
        this.brandServices = brandServices;
    }

    @PostMapping
    public int create(@RequestBody SaveBrandRequest request) {
        return brandServices.save(request);
    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandServices.findAll();
    }

    @GetMapping("/{brandId}")
    public Optional<Brand> getBrandById(@PathVariable Integer brandId) {
        return brandServices.findAllById(brandId);
    }

    @PutMapping
    public int update(@PathVariable SaveBrandRequest request) {
        return brandServices.save(request);
    }

    @DeleteMapping("/{brandId}")
    public void delete(@PathVariable int brandId) {
        brandServices.delete(brandId);
    }
}
