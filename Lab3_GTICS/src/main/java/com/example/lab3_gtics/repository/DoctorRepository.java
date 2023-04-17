package com.example.lab3_gtics.repository;

import com.example.lab3_gtics.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findByHospitalId(int idHospital);
}
