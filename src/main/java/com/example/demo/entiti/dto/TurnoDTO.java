package com.example.demo.entiti.dto;

import com.example.demo.entiti.Odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private Long id;
    private Odontologo odontologo;
}
