package com.example.demo.service;

import com.example.demo.entiti.dto.OdontologoDTO;

import java.util.Set;

public interface IOdontologoService {
    OdontologoDTO listarOdon(Long id);
    Set<OdontologoDTO> listarTodos();
    void agregarOdon(OdontologoDTO odontologoDTO);
    void modificarOdon(OdontologoDTO odontologoDTO);
    void eliminarOdon(Long id);
}
