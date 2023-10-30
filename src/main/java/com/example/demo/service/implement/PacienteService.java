package com.example.demo.service.implement;

import com.example.demo.entiti.Paciente;
import com.example.demo.entiti.dto.PacienteDTO;
import com.example.demo.repository.IPacienteRepository;
import com.example.demo.service.IPacienteService;
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
public class PacienteService implements IPacienteService {
    private static final Logger logger = Logger.getLogger(ITurnoService.class);
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public PacienteDTO listarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        logger.info("Se encontro el paciente con id:" + id);
        return mapper.convertValue(paciente, PacienteDTO.class);

    }

    @Override
    public Set<PacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        for (Paciente paciente: pacientes) {
            logger.info("Listando todos los pacientes");
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }
    public void pacienteAux(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void agregarPaciente(PacienteDTO pacienteDTO) {
        pacienteAux(pacienteDTO);
        logger.info("Se agrego el nuevo paciente");
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        pacienteAux(pacienteDTO);
        logger.info("Se ha modificado el paciente");
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("Se ha eliminado el paciente con id: "+id);
    }
}
