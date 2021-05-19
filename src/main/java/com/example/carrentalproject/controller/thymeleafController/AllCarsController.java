package com.example.carrentalproject.controller.thymeleafController;

import com.example.carrentalproject.service.CarServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AllCarsController {
    private CarServices carServices;

    public AllCarsController(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/allCars")
    public String index(final ModelMap modelMap, @RequestParam(value = "q", required = false) String q) {

        var cars = q != null && q != "" ? this.carServices.search(q) : this.carServices.findAll();
        modelMap.addAttribute("cars", cars);

        var featuredCars = this.carServices.featured();
        modelMap.addAttribute("featuredCars", featuredCars);

        return "gallery";
    }
}
