package com.example.demo.controller;


import com.example.demo.entiti.dto.OdontologoDTO;
import com.example.demo.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.agregarOdon(odontologoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se creo el odontologo");
    }

    @GetMapping("/listarTodos")
    public Set<OdontologoDTO> listarOdontologos() {
        return odontologoService.listarTodos();
    }

    @GetMapping("/{id}")
    public OdontologoDTO listarOdontologoPorId(@PathVariable Long id){
        return odontologoService.listarOdon(id);
    }

    @PutMapping()
    public ResponseEntity<String> actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.modificarOdon(odontologoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se actualizo este odontologo");
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable("id") Long id){
        odontologoService.eliminarOdon(id);
        return ResponseEntity.status(HttpStatus.OK).body("El odontologo fue eliminado");
    }
}
