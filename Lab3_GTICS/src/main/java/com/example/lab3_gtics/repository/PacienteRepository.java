package com.example.lab3_gtics.repository;

import com.example.lab3_gtics.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    List<Paciente> findByHospitalId(int idHospital);
    List<Paciente> findByDoctorId(int idDoctor);
}
