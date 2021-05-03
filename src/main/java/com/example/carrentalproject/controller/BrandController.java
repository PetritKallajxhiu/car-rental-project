package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("brand/create")
    public Brand addBrand(@RequestBody Brand brand) {
        return brandService.addBrand(brand);
    }

    @GetMapping("brands")
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }

    @GetMapping("brands/{brandId}")
    public ResponseEntity<?> getBrandById(@PathVariable Integer brandId) {
        return brandService.getBrandById(brandId);
    }

    @PutMapping("brand/update/{brandId}")
    public ResponseEntity<?> updateBrand(@PathVariable Integer brandId, @Valid @RequestBody Brand brandRequest) {
        return brandService.updateBrand(brandId, brandRequest);
    }

    @DeleteMapping("brand/delete/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable Integer brandId) {
        return brandService.deleteBrand(brandId);
    }

}
