package com.example.lab3_gtics.controllers;

import com.example.lab3_gtics.entity.Doctor;
import com.example.lab3_gtics.entity.Hospital;
import com.example.lab3_gtics.entity.Paciente;
import com.example.lab3_gtics.repository.DoctorRepository;
import com.example.lab3_gtics.repository.PacienteRepository;
import org.springframework.ui.Model;
import com.example.lab3_gtics.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/hospitales")
public class HospitalController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;
    public HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository){
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/lista")
    public String listar(Model model){
        List<Hospital> listaHospitales = hospitalRepository.findAll();
        model.addAttribute("listaHospitales",listaHospitales);
        return ("hospital/lista");
    }
    @GetMapping("/doctores")
    public String listarDoctores(Model model, @RequestParam("id") int idDoctor){
        List<Doctor> listaDoctores = doctorRepository.findByHospitalId(idDoctor);
        model.addAttribute("listaDoctores", listaDoctores);
        return "hospital/listaDoctores";
    }

    @GetMapping("/pacientes")
    public String listarPacientes(Model model, @RequestParam("id") int idPaciente){
        List<Paciente> listaPacientes = pacienteRepository.findByHospitalId(idPaciente);
        model.addAttribute("listaPacientes", listaPacientes);
        return "hospital/listaPacientes";
    }

}
