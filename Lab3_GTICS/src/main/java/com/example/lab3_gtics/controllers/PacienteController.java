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

import java.util.Deque;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;
    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository){
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/lista")
    public String listar(Model model){
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        model.addAttribute("listaPacientes",listaPacientes);
        return ("paciente/lista");
    }
    @GetMapping("/editarPaciente")
    public String editar(Model model, @RequestParam("id") int idPaciente){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(idPaciente);
        if(pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();
            model.addAttribute("paciente", paciente);
            return "paciente/editar";
        }else{
            return "redirect:/pacientes/lista";
        }
    }

    @GetMapping("/derivar")
    public String derivar(Model model, @RequestParam("id") int idPaciente){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(idPaciente);
        if(pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();
            List<Doctor> listaDoctores = doctorRepository.findAll();
            model.addAttribute("paciente", paciente);
            model.addAttribute("listaDoctores", listaDoctores);
            return "paciente/derivar";
        }else{
            return "redirect:/pacientes/lista";
        }
    }

}
