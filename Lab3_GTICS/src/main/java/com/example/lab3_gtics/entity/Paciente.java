package com.example.lab3_gtics.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.StringReader;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idPaciente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "fecha_cita")
    private Date fechaCita;

    @Column(name = "numero_habitacion")
    private int numeroHabitacion;

    @Column(name = "doctor_id")
    private int idDoctor;

    @Column(name = "hospital_id")
    private int idHospital;

}
