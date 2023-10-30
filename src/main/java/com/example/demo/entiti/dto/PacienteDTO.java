package com.example.demo.entiti.dto;

public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;

    public PacienteDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
