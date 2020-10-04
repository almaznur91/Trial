package ru.inovus.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inovus.test.service.CarNumberService;

@Controller
@RequestMapping("/")
public class CarNumberController {

    private final CarNumberService service;

    @Autowired
    public CarNumberController(CarNumberService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll() {
        return "index";
    }

    @GetMapping(value = "/random")
    public String random(Model model) {
        model.addAttribute("random", service.randomNumber());
        return "random";
    }

    @GetMapping(value = "/next")
    public String next(Model model) {
        model.addAttribute("next", service.nextNumber());
        return "next";
    }

}
