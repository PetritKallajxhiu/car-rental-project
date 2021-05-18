package com.example.carrentalproject.controller;

import com.example.carrentalproject.service.BannerServices;
import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.CommentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CarDetailController {
    private CarServices carServices;
    private BannerServices bannerServices;
    private CommentServices commentServices;

    public CarDetailController(CarServices carServices, BannerServices bannerServices, CommentServices commentServices) {
        this.carServices = carServices;
        this.bannerServices = bannerServices;
        this.commentServices = commentServices;
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable int id, final ModelMap modelMap) {
        var comments = commentServices.findAll();
        modelMap.addAttribute("comments", comments);

        var details = carServices.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("details", details);
        return "car_details";

    }
}
