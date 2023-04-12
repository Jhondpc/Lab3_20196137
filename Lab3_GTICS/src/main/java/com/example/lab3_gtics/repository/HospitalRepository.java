package com.example.lab3_gtics.repository;

import com.example.lab3_gtics.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository
extends JpaRepository<Hospital,Integer> {
}
