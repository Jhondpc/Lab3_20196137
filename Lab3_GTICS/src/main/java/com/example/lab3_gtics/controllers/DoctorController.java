package com.example.lab3_gtics.controllers;

import com.example.lab3_gtics.repository.DoctorRepository;
import com.example.lab3_gtics.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {
    final DoctorRepository doctorRepository;
    public DoctorController(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("lista", doctorRepository.findAll());
        return "doctor/lista";
    }
}
