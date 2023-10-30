package com.example.demo.service.implement;

import com.example.demo.entiti.Odontologo;
import com.example.demo.entiti.dto.OdontologoDTO;
import com.example.demo.repository.IOdontologoRepository;
import com.example.demo.service.IOdontologoService;
import com.example.demo.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    private static final Logger logger = Logger.getLogger(ITurnoService.class);
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public OdontologoDTO listarOdon(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        logger.info("Se ha encontrado el odontologo con id: "+id);
        return mapper.convertValue(odontologo, OdontologoDTO.class);
    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();

        for (Odontologo odontologo: odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("Se han listado todos los odontologos");
        return odontologosDTO;
    }
    public void odontologoAux(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void agregarOdon(OdontologoDTO odontologoDTO) {
        odontologoAux(odontologoDTO);
        logger.info("Se ha agregado un nuevo odontologo");
    }

    @Override
    public void modificarOdon(OdontologoDTO odontologoDTO) {
        odontologoAux(odontologoDTO);
        logger.info("Se ha modificado el odontologo");
    }

    @Override
    public void eliminarOdon(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("Se ha eliminado el odontologo con id: "+id);
    }
}
