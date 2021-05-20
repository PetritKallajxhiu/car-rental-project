package com.example.carrentalproject.controller.thymeleafController;

import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.ReservationServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoReservationController {
    private CarServices carService;
    private ReservationServices reservationService;

    public DoReservationController(CarServices carService, ReservationServices reservationService) {
        this.carService = carService;
        this.reservationService = reservationService;
    }

    @RequestMapping("/reservation/{id}")
    public String reserve(@PathVariable int id, final ModelMap modelMap) {
        var choosedCar = this.carService.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("choosedCar", choosedCar);

        return "reservation";
    }
}
