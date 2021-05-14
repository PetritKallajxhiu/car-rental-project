package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Brand;
import com.example.carrentalproject.repository.BrandRepository;
import com.example.carrentalproject.service.BrandServices;
import com.example.carrentalproject.service.SaveBrandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandServices {

    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findAllById(int brandId) {
        return brandRepository.findById(brandId);
    }

    @Override
    public int save(SaveBrandRequest brandRequest) {
        var brand = brandRepository.findById(brandRequest.getId());
        if (brand.isPresent()) {
            brand.get().setName(brandRequest.getName());
            brandRepository.save(brand.get());
            return brand.get().getId();
        } else {
            var newBrand = Brand.builder()
                    .name(brandRequest.getName())
                    .createdAt(new Date())
                    .build();
            brandRepository.save(newBrand);
            return newBrand.getId();
        }
    }

    @Override
    public void delete(int brandId) {
        var brand = brandRepository.findById(brandId).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        brandRepository.delete(brand);
    }
}
