package com.example.demo;

import com.example.demo.entiti.dto.OdontologoDTO;
import com.example.demo.service.implement.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OdontologoServiceTest {
	@Autowired
	OdontologoService odontologoService;

	@Test
	public void testOdontologoService(){

		OdontologoDTO odontologoDTO = new OdontologoDTO();
		odontologoDTO.setNombre("Daniel");
		odontologoDTO.setApellido("Bello");

		odontologoService.agregarOdon(odontologoDTO);

		assertNotNull(odontologoService.listarTodos());


	}

}
