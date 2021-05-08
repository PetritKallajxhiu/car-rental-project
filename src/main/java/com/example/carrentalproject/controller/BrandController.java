package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.service.SaveBrandRequest;
import com.example.carrentalproject.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public int create(@RequestBody SaveBrandRequest request) {
        return brandService.save(request);
    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.findAll();
    }

    @GetMapping("/{brandId}")
    public Optional<Brand> getBrandById(@PathVariable Integer brandId) {
        return brandService.findAllById(brandId);
    }

    @PutMapping("/{brandId}")
    public int update(@PathVariable SaveBrandRequest request) {
        return brandService.save(request);
    }

    @DeleteMapping("/{brandId}")
    public void delete(@PathVariable int brandId) {
        brandService.delete(brandId);
    }
}
