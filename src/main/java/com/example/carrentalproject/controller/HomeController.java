package com.example.carrentalproject.controller;

import com.example.carrentalproject.service.BannerServices;
import com.example.carrentalproject.service.CarServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Eshte i tille pasi then HTML dhe jo JS
public class HomeController {
    private CarServices carServices;
    private BannerServices bannerServices;

    public HomeController(CarServices carServices, BannerServices bannerServices) {
        this.carServices = carServices;
        this.bannerServices = bannerServices;
    }

    @GetMapping("/")
    public String index(final ModelMap modelMap) {

        var carTypes = this.carServices.findAll();
        modelMap.addAttribute("carTypes", carTypes);

        var banners = this.bannerServices.findAll();
        modelMap.addAttribute("banners", banners);


        var featuredCars = this.carServices.featured();
        modelMap.addAttribute("featuredCars", featuredCars);

        return "index_2";
    }


}
