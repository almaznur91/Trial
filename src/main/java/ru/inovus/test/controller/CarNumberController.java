package ru.inovus.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.inovus.test.dto.CarNumberDto;
import ru.inovus.test.entity.CarNumberEntity;
import ru.inovus.test.repository.CarNumberRepository;
import ru.inovus.test.service.CarNumberService;

@Controller
@RequestMapping("/number")
public class CarNumberController {

    private final CarNumberService service;
    private final CarNumberRepository carNumberRepository;
    private final CarNumberService carNumberService;

    @Autowired
    public CarNumberController(CarNumberService service, CarNumberRepository carNumberRepository, CarNumberService carNumberService) {
        this.service = service;
        this.carNumberRepository = carNumberRepository;
        this.carNumberService = carNumberService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(value = "/random")
    public String random(Model model) {
        model.addAttribute("random", service.nextRandom());
        return "random";
    }

    @GetMapping(value = "/next")
    public String next(Model model, @ModelAttribute CarNumberDto carNumberDto) {
        model.addAttribute("next", service.nextNumber());
        carNumberService.saveCarNumber(carNumberDto);
        return "next";
    }

    @GetMapping(value = "/all")
    public String getAll(Model model) {
        model.addAttribute("all", carNumberRepository.findAll());
        return "all";
    }

}
