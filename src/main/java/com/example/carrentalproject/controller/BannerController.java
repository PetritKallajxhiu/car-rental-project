package com.example.carrentalproject.controller;

import com.example.carrentalproject.model.Banner;
import com.example.carrentalproject.service.BannerServices;
import com.example.carrentalproject.service.SaveBannerRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banners")
public class BannerController {
    private final BannerServices bannerService;

    public BannerController(BannerServices bannerService) {
        this.bannerService = bannerService;
    }

    @PostMapping
    public int addBanner(@RequestBody SaveBannerRequest request) {
        return bannerService.save(request);
    }

    @GetMapping
    public List<Banner> getBanners() {
        return bannerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Banner> findById(@PathVariable int id) {
        return bannerService.findById(id);
    }

    @PutMapping
    public int updateBanner(@Valid @RequestBody SaveBannerRequest request) {
        return bannerService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bannerService.delete(id);
    }
}
