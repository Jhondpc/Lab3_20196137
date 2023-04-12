package com.example.lab3_gtics.controllers;

import org.springframework.ui.Model;
import com.example.lab3_gtics.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {

    final HospitalRepository hospitalRepository;
    public HospitalController(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("lista", hospitalRepository.findAll());
        return "hospital/lista";
    }
}
