package com.example.carrentalproject.service;

import com.example.carrentalproject.model.Banner;

import java.util.List;
import java.util.Optional;

public interface BannerServices {
    List<Banner> findAll();

    Optional<Banner> findById(int id);

    int save(SaveBannerRequest request);

    void delete(int id);
}
