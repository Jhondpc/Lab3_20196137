package com.example.lab3_gtics.controllers;

import com.example.lab3_gtics.repository.HospitalRepository;
import com.example.lab3_gtics.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {
    final PacienteRepository pacienteRepository;
    public PacienteController(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("lista", pacienteRepository.findAll());
        return "paciente/lista";
    }
}
