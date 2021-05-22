package com.example.carrentalproject.controller.thymeleafController;

import com.example.carrentalproject.service.CarServices;
import com.example.carrentalproject.service.ReservationServices;
import com.example.carrentalproject.service.SaveReservationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        var selectedCar = this.carService.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("selectedCar", selectedCar);

        var reservation = new SaveReservationRequest();
        reservation.setCarId(selectedCar.getId());
        reservation.setFinalPrice(selectedCar.getPrice());
        modelMap.addAttribute("reservation", reservation);

        return "reservation";
    }

    @PostMapping("/reserve")
    public String reservation(@Valid SaveReservationRequest reservation, final ModelMap modelMap) {
        modelMap.addAttribute("reservation", reservation);
        reservationService.save(reservation);

        var selectedCar = this.carService.findById(reservation.getCarId()).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("selectedCar", selectedCar);

        return "reserved";
    }

//    @PostMapping("/reservation")
//    public String reservation(ModelMap modelMap) {
//        SaveReservationRequest reservation = new SaveReservationRequest();
//        modelMap.addAttribute("reservation", reservation);

//        var selectedCar = this.carService.findById(reservation.getCarId()).orElseThrow(() -> new RuntimeException("Invalid id"));
//        modelMap.addAttribute("selectedCar", selectedCar);
//
//        reservationService.save(reservation);
//
//        return "reserved";
//    }

}
