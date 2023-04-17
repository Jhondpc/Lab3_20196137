package com.example.lab3_gtics.controllers;

import com.example.lab3_gtics.entity.Doctor;
import com.example.lab3_gtics.entity.Paciente;
import com.example.lab3_gtics.repository.DoctorRepository;
import com.example.lab3_gtics.repository.HospitalRepository;
import com.example.lab3_gtics.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/doctores")
public class DoctorController {
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;
    public DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository){
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/lista")
    public String listar(Model model){
        List<Doctor> listaDoctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores",listaDoctores);
        return ("doctor/lista");
    }
    @GetMapping("/listaPacientes")
    public String lista(Model model, @RequestParam("id") int idPaciente){
        List<Paciente> listaPacientes = pacienteRepository.findByDoctorId(idPaciente);
        model.addAttribute("listaPacientes", listaPacientes);
        return "doctor/listaPacientes";
    }

}
