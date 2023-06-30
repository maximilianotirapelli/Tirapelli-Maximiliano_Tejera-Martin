package com.backend.integrador.service.impl;

import com.backend.integrador.dto.PacienteDto;
import com.backend.integrador.entity.Domicilio;
import com.backend.integrador.entity.Paciente;
import com.backend.integrador.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    void deberiaGuardarUnPaciente() {
        Paciente guardarUnPaciente = new Paciente("Bart", "Simpson", "32258369", LocalDate.now(), new Domicilio("calle falsa", 123, "Yerba buena", "Springfield"));
        PacienteDto pacienteDto = pacienteService.guardarPaciente(guardarUnPaciente);

        Assertions.assertNotNull(pacienteDto);
        Assertions.assertNotNull(pacienteDto.getId());

    }

    @Test
    @Order(2)
    void deberiaListarElPaciente() {
        List<PacienteDto> pacienteDto = pacienteService.listarPacientes();
        assertEquals(1, pacienteDto.size());
    }

    @Test
    @Order(3)
    void deberiaEliminarElPaciente() throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }

    @Test
    @Order(4)
    void deberiaRetornarListaVacia() {
        List<PacienteDto> pacienteDtos = pacienteService.listarPacientes();
        Assertions.assertTrue(pacienteDtos.isEmpty());
    }
}