package com.example.demo.service;

import com.example.demo.entiti.dto.TurnoDTO;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
}
