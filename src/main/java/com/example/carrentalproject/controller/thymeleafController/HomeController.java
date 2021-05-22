package com.example.carrentalproject.controller.thymeleafController;

import com.example.carrentalproject.service.BannerServices;
import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.CommentServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Eshte i tille pasi then HTML dhe jo JS
public class HomeController {
    private CarServices carServices;
    private BannerServices bannerServices;
    private CommentServices commentServices;

    public HomeController(CarServices carServices, BannerServices bannerServices, CommentServices commentServices) {
        this.carServices = carServices;
        this.bannerServices = bannerServices;
        this.commentServices = commentServices;
    }

    @GetMapping("/")
    public String index(final ModelMap modelMap) {

        var carTypes = this.carServices.findAll();
        modelMap.addAttribute("carTypes", carTypes);

        var banners = this.bannerServices.findAll();
        modelMap.addAttribute("banners", banners);

        var comments = commentServices.findAll();
        modelMap.addAttribute("comments", comments);

        var featuredCars = this.carServices.featured();
        modelMap.addAttribute("featuredCars", featuredCars);

        return "index_2";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutUs(ModelMap modelMap) {
        var comments = commentServices.findAll();
        modelMap.addAttribute("comments", comments);
        return "about";
    }


}
