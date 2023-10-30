package com.example.demo.controller;

import com.example.demo.entiti.dto.TurnoDTO;
import com.example.demo.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @PostMapping()
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se creo el nuevo turno");
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable("id") Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado el turno");
    }
}
