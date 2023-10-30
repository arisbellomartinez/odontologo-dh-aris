package com.example.demo.service.implement;

import com.example.demo.entiti.Turno;
import com.example.demo.entiti.dto.TurnoDTO;
import com.example.demo.repository.ITurnoRepository;
import com.example.demo.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TurnoService implements ITurnoService {
    private static final Logger logger = Logger.getLogger(ITurnoService.class);
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        logger.info("Ha sido creado el nuevo turno");
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        logger.info("Se ha eliminado el turno");
    }
}
