package com.example.carrentalproject.service.impl;

import com.example.carrentalproject.model.Banner;
import com.example.carrentalproject.repository.BannerRepository;
import com.example.carrentalproject.service.BannerServices;
import com.example.carrentalproject.service.SaveBannerRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BannerServiceImpl implements BannerServices {

    private final BannerRepository bannerRepository;

    public BannerServiceImpl(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public List<Banner> findAll() {
        return bannerRepository.findAll();
    }

    @Override
    public Optional<Banner> findById(int carId) {
        return bannerRepository.findById(carId);
    }

    @Override
    public int save(SaveBannerRequest request) {
        var banner = bannerRepository.findById(request.getId());
        if (banner.isPresent()) {
            banner.get().setName(request.getName());
            banner.get().setPhoto(request.getPhoto());
            bannerRepository.save(banner.get());

            return banner.get().getId();
        } else {
            var newBanner = Banner.builder()
                    .name(request.getName())
                    .photo(request.getPhoto())
                    .createdAt(new Date())
                    .build();
            bannerRepository.save(newBanner);
            return newBanner.getId();
        }
    }

    @Override
    public void delete(int id) {
        var banner = bannerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        bannerRepository.delete(banner);
    }
}
